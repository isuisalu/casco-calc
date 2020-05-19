package eu.banking.casco.service;

import eu.banking.casco.CascoCalcApplication;
import eu.banking.casco.model.Car;
import eu.banking.casco.repository.CarRepository;
import eu.banking.casco.repository.CascoRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Test
    public void testService() {
        dataImportService.importAll();
        Pageable firstPageWithOneElement = PageRequest.of(0, 1);
        Page<Car> carPage = carRepository.findAll(firstPageWithOneElement);
        BigDecimal annual = service.computeAnnualCasco(carPage.get().findFirst().get());
        assertThat(annual.intValue(), is(1213));
   }
    @Ignore("Run it manually, takes 2 min approx")
    @Test
    public void testRecalculation() {
        dataImportService.importAll();
        long start = System.currentTimeMillis();
        service.reCalculateCascos();
        long end = System.currentTimeMillis();
        System.out.println("reCalculateCascos took " + (end - start) + " ms");
        assertThat(cascoRepository.findAll().size(), is(64180));
    }
}
