package eu.banking.casco.service;

import eu.banking.casco.CascoCalcApplication;
import eu.banking.casco.model.AvgPurchasePrice;
import eu.banking.casco.model.Car;
import eu.banking.casco.model.MakeCoefficient;
import eu.banking.casco.model.RiskCoefficient;
import eu.banking.casco.repository.AvgPurchasePriceRepository;
import eu.banking.casco.repository.CarRepository;
import eu.banking.casco.repository.MakeCoefficientRepository;
import eu.banking.casco.repository.RiskCoefficientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = NONE,
        classes = {CascoCalcApplication.class, TestConfiguration.class})
public class DataImportServiceTest {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private RiskCoefficientRepository riskCoefficientRepository;
    @Autowired
    private MakeCoefficientRepository makeCoefficientRepository;
    @Autowired
    private AvgPurchasePriceRepository avgPurchasePriceRepository;

    @Autowired
    private DataImportService dataImportService;

    @Test
    public void testCarsImport() {
        dataImportService.importCars("vehicles.csv");
        List<Car> cars = carRepository.findAll();
        assertThat(cars.size(), is(64195));
    }
    @Test
    public void importRiskData() {
       dataImportService.importRiskData("data.json");
       List<RiskCoefficient> risks = riskCoefficientRepository.findAll();
       assertThat(risks.size(), is(3));
       List<MakeCoefficient> makes = makeCoefficientRepository.findAll();
       assertThat(makes.size(), is(6));
       List<AvgPurchasePrice> prices = avgPurchasePriceRepository.findAll();
       assertThat(prices.size(), is(11));
    }
}
