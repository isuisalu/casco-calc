package eu.banking.casco.repository;

import eu.banking.casco.CascoCalcApplication;
import eu.banking.casco.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = NONE,
        classes = {CascoCalcApplication.class, TestConfiguration.class})
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void testRepository() {
        Car car = new Car();
        car.setPlateNumber("111XXX");
        car.setProducer("volvo");
        car.setFirstRegistration(2011);
        car.setPurchasePrice(12000);
        car.setMileage(20000);
        car.setPreviousIndemnity(BigDecimal.valueOf(2100));

        carRepository.save(car);

        assertThat(carRepository.findAll().size(), is(1));
    }
}
