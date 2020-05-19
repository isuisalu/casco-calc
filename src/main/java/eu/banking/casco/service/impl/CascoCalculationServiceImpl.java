package eu.banking.casco.service.impl;

import eu.banking.casco.model.AvgPurchasePrice;
import eu.banking.casco.model.Car;
import eu.banking.casco.model.Casco;
import eu.banking.casco.model.MakeCoefficient;
import eu.banking.casco.repository.*;
import eu.banking.casco.service.CascoCalculationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class CascoCalculationServiceImpl implements CascoCalculationService {

    private final RiskCoefficientRepository riskCoefficientRepository;
    private final MakeCoefficientRepository makeCoefficientRepository;
    private final AvgPurchasePriceRepository avgPurchasePriceRepository;
    private final CarRepository carRepository;
    private final CascoRepository cascoRepository;

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchSize = 20;

    public void reCalculateCascos() {
        final List<Casco> saveBatch = new ArrayList<>();
        int total = 0;
        long begin = System.currentTimeMillis();

        for (Car c : carRepository.findAll()) {
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
                saveBatch.add(casco);
                total++;
                if (saveBatch.size() >= batchSize) {
                    try {
                        cascoRepository.saveAll(saveBatch);
                        cascoRepository.flush();
                        saveBatch.clear();
                        long now = System.currentTimeMillis();
                        log.debug("Total saved cascos: {}, batch {} took {} ms", total, batchSize,
                                (now - begin));
                        begin = now;
                    } catch (Exception e) {
                        log.error("Error in saving casco for car {}: {}",
                                c.getPlateNumber(), e.getMessage());
                    }
                }
            }
        }
        if (saveBatch.size() > 0) {
            cascoRepository.saveAll(saveBatch);
        }
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
        if (car.getPreviousIndemnity() != null) {
            BigDecimal prevIndemnityRisk = riskCoefficientRepository
                    .findByName(RiskCoefficientRepository.PREVIOUS_INDEMNITY_RISK)
                    .getValue();
            annual += prevIndemnityRisk.doubleValue() * car.getPreviousIndemnity().doubleValue();
        }
        MakeCoefficient make = makeCoefficientRepository
                .findByName(car.getProducer().toLowerCase());
        double makeCoefficient = (make != null) ? make.getValue().doubleValue() : 1.;
        annual *= makeCoefficient;
        return BigDecimal.valueOf(annual);
    }

    private double computeVehiclePricePrecentage(int age, int mileage) {
        double precent = 102. + (-7.967 * (double) age) + 0.8337334 * Math.pow((double) age, 2.) +
                (-0.07785488) * Math.pow((double) age, 3.) + (0.002518395) * Math.pow((double) age, 4.) +
                (-0.0002236396) * mileage + (3.669157e-10) * Math.pow((double) mileage, 2.) +
                (-1.813681e-16) * Math.pow((double) mileage, 3.);
        return precent / 100;
    }
}
