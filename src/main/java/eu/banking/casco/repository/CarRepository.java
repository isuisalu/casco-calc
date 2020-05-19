package eu.banking.casco.repository;

import eu.banking.casco.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, Long>,
        JpaRepository<Car, Long> {
}