package eu.banking.casco.service;

import eu.banking.casco.CascoCalcApplication;
import eu.banking.casco.model.Car;
import eu.banking.casco.repository.CarRepository;
import eu.banking.casco.repository.CascoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
import static org.hamcrest.core.Is.is;

@Profile("test")
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = NONE,
        classes = {CascoCalcApplication.class, TestConfiguration.class})
public class CascoCalculationServiceTest {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CascoRepository cascoRepository;
    @Autowired
    private CascoCalculationService service;
    @Autowired
    private DataImportService dataImportService;

    @Before
    public void before() {
        dataImportService.importAll();
    }

    @Test
    public void testService() {
        List<Car> cars = carRepository.findAll();
        BigDecimal annual = service.computeAnnualCasco(cars.get(0));
        assertThat(annual.intValue(), is(1090));
    }
    @Test
    public void testRecalculation() {
        long start = System.currentTimeMillis();
        service.reCalculateCascos();
        long end = System.currentTimeMillis();
        System.out.println("reCalculateCascos took " + (end - start) + " ms");
        //log.info("reCalculateCascos took {} ms", end - start);
        assertThat(cascoRepository.findAll().size(), is(64184));
    }
}
