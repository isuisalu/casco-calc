package eu.banking.casco.repository;

import eu.banking.casco.model.Car;

import java.util.List;

public interface CarRepository {
    List<Car> findAll();
    void save(Car car);
}
