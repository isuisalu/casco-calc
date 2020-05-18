package eu.banking.casco.repository;

import eu.banking.casco.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Profile("test")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
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

        carRepository.save(car);

        assertThat(carRepository.findAll().size(), is(1));
    }
}
