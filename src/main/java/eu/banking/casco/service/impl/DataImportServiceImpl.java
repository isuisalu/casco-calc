package eu.banking.casco.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.banking.casco.model.AvgPurchasePrice;
import eu.banking.casco.model.Car;
import eu.banking.casco.model.MakeCoefficient;
import eu.banking.casco.model.RiskCoefficient;
import eu.banking.casco.repository.AvgPurchasePriceRepository;
import eu.banking.casco.repository.CarRepository;
import eu.banking.casco.repository.MakeCoefficientRepository;
import eu.banking.casco.repository.RiskCoefficientRepository;
import eu.banking.casco.service.DataImportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Log4j2
@Service
public class DataImportServiceImpl implements DataImportService {

    private final CarRepository carRepository;
    private final RiskCoefficientRepository riskCoefficientRepository;
    private final MakeCoefficientRepository makeCoefficientRepository;
    private final AvgPurchasePriceRepository avgPurchasePriceRepository;

    private ObjectMapper mapper = new ObjectMapper();

    public void importAll() {
        importCars("vehicles.csv");
        importRiskData("data.json");
    }
    public void importCars() {
        importCars("vehicles.csv");
    }
    public void importCars(String fileName) {
        final Map<String, String> carsMap = new HashMap<>();
        BufferedReader reader;
        Car car = null;
        try {
            InputStream is = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(fileName);
            reader = new BufferedReader(new InputStreamReader(is));
            String line = reader.readLine(); // header row
            while ((line = reader.readLine()) != null) {
                try {

                    String[] cols = line.split(",");

                    int firstRegistration = Integer.parseInt(cols[2]);
                    if (firstRegistration >= 2020 || firstRegistration < 1950) {
                        log.warn("unrealistic firstRegistration {}", firstRegistration);
                        continue;
                    }
                    if (carsMap.get(cols[1]) == null) {
                        carsMap.put(cols[1], cols[1]);
                        car = new Car();
                        car.setPlateNumber(cols[1]);
                        car.setFirstRegistration(Integer.parseInt(cols[2]));
                        car.setPurchasePrice(Integer.parseInt(cols[3]));
                        car.setProducer(cols[4]);
                        car.setMileage(Integer.parseInt(cols[5]));
                        car.setPreviousIndemnity(new BigDecimal(cols[6]));
                    } else {
                        continue;
                    }
                } catch (Exception e) {
                    log.error("Exception reading car with reg. number {}: {}",
                            car.getPlateNumber(), e.getMessage());
                    continue;
                }
                if (car != null) {
                    carRepository.save(car);
                }
            }
            reader.close();
        } catch (Exception e) {
            String msg = String.format("Exception during cars import of car %s : ", car);
            log.error(msg, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void importRiskData() {
        importRiskData("data.json");
    }
    @SuppressWarnings("unchecked")
    public void importRiskData(String fileName) {
        try {
            InputStream is = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(fileName);
            Map<String, Map> riskData = ((Map<String, Map>)mapper.readValue(is, Map.class))
                    .get("data");

            Map<String, Double> coefficients = (Map<String, Double>)riskData.get("coefficients");
            for (String key : coefficients.keySet()) {
                RiskCoefficient coefficient = new RiskCoefficient();
                coefficient.setName(key);
                coefficient.setInUse(true);
                coefficient.setValue(BigDecimal.valueOf(coefficients.get(key)));
                riskCoefficientRepository.save(coefficient);
            }
            Map<String, Double> makeCoefficients = (Map<String, Double>)riskData
                    .get("make_coefficients");
            for (String key : makeCoefficients.keySet()) {
                MakeCoefficient coefficient = new MakeCoefficient();
                coefficient.setName(key.toLowerCase());
                BigDecimal value = null;
                Object valueObj = makeCoefficients.get(key);
                if (valueObj instanceof Double) {
                    value = BigDecimal.valueOf((Double)valueObj);
                } else if (valueObj instanceof Integer) {
                    value = BigDecimal.valueOf((Integer)valueObj);
                }
                coefficient.setValue(value);
                makeCoefficientRepository.save(coefficient);
            }
            Map<String, Integer> avgPurchasePrices = (Map<String, Integer>)riskData
                    .get("avg_purchase_price");
            for (String key : avgPurchasePrices.keySet()) {
                AvgPurchasePrice avgPurchasePrice = new AvgPurchasePrice();
                avgPurchasePrice.setProducer(key.toLowerCase());
                avgPurchasePrice.setPrice(BigDecimal.valueOf((Integer)avgPurchasePrices.get(key)));
                avgPurchasePriceRepository.save(avgPurchasePrice);
            }
        } catch (Exception e) {
            log.error("Exception during risk data import: ", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
