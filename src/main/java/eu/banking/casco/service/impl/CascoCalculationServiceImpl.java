package eu.banking.casco.service.impl;

import eu.banking.casco.model.AvgPurchasePrice;
import eu.banking.casco.model.Car;
import eu.banking.casco.model.Casco;
import eu.banking.casco.model.MakeCoefficient;
import eu.banking.casco.repository.*;
import eu.banking.casco.service.CascoCalculationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Log4j2
@RequiredArgsConstructor
@Service
public class CascoCalculationServiceImpl implements CascoCalculationService {

    private final RiskCoefficientRepository riskCoefficientRepository;
    private final MakeCoefficientRepository makeCoefficientRepository;
    private final AvgPurchasePriceRepository avgPurchasePriceRepository;
    private final CarRepository carRepository;
    private final CascoRepository cascoRepository;


    public void reCalculateCascos() {
        carRepository.findAll().stream()
                .forEach(c -> {
                    BigDecimal annual = computeAnnualCasco(c);
                    if (annual != null) {
                        Casco casco = cascoRepository
                                .findByPlateNumber(c.getPlateNumber());
                        if (casco == null) {
                            casco = new Casco();
                            casco.setCar(c);
                            casco.setAnnual(annual);
                        }
                        casco.setAnnual(annual);
                        double monthly = annual.doubleValue() / 12.;
                        casco.setMonthly(BigDecimal.valueOf(monthly));
                        cascoRepository.save(casco);
                    }
                });
    }
    @Override
    public BigDecimal computeAnnualCasco(Car car) {
        int age = OffsetDateTime.now().getYear() - car.getFirstRegistration();
        BigDecimal ageRisk = riskCoefficientRepository
                .findByName(RiskCoefficientRepository.VEHICLE_AGE_RISK)
                .getValue();
        double annual = ageRisk.doubleValue() * age;

        BigDecimal valueRisk = riskCoefficientRepository
                .findByName(RiskCoefficientRepository.VEHICLE_VALUE_RISK)
                .getValue();
        AvgPurchasePrice purchasePrice = avgPurchasePriceRepository
                .findByProducer(car.getProducer().toLowerCase());
        if (purchasePrice != null) {
            double carValue = computeVehiclePricePrecentage(age, car.getMileage()) *
                    purchasePrice.getPrice().doubleValue();
            annual += valueRisk.doubleValue() * carValue;
        } else {
            log.warn("Couldn't find purchasePrice for car with reg. number {} and producer {}",
                    car.getPlateNumber(), car.getProducer());
            return null;
        }
        MakeCoefficient make = makeCoefficientRepository
                .findByName(car.getProducer().toLowerCase());
        double makeCoefficient = (make != null) ? make.getValue().doubleValue() : 1.;
        annual *= makeCoefficient;
        return BigDecimal.valueOf(annual);
    }

    private double computeVehiclePricePrecentage(int age, int mileage) {
        double precent = 102. + (-7.967 * (double)age) + 0.8337334 * Math.pow((double)age, 2.) +
                (-0.07785488) * Math.pow((double)age, 3.) + (0.002518395) * Math.pow((double)age, 4.) +
                (-0.0002236396) * mileage + (3.669157e-10) * Math.pow((double)mileage, 2.) +
                (-1.813681e-16) * Math.pow((double)mileage, 3.);
        return precent / 100;
    }
}
