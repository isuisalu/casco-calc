package eu.banking.casco.controller;

import eu.banking.casco.model.Car;
import eu.banking.casco.model.RiskCoefficient;
import eu.banking.casco.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class CarsController {

    private final CarRepository carRepository;

    @GetMapping("cars")
    public HttpEntity<?> getCars() {
        List<Car> cars = carRepository.findAll();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
    @PostMapping("car")
    public Car addCar(@RequestBody @Valid Car car) {
        return carRepository.save(car);
    }
    @PutMapping("car/{id}")
    public HttpEntity<?> updateCar(@PathVariable("id") final long id,
                                               @RequestBody @Valid  Car car) {
        car.setId(id);
        Car saved = carRepository.save(car);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
    @DeleteMapping("car/{id}")
    public HttpEntity<?> deleteCar(@PathVariable("id") final long id) {
        carRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
