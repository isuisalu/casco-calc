package eu.banking.casco.repository.impl;

import eu.banking.casco.model.Car;
import eu.banking.casco.repository.CarRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class CarRepositoryImpl implements CarRepository {

    private Map<String, Car> cars = new HashMap<>();

    public List<Car> findAll() {
        return new ArrayList<Car>(cars.values());
    }
    @Override
    public void save(Car car) {
        cars.put(car.getPlateNumber(), car);
    }
}
