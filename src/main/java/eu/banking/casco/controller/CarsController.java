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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
