package eu.banking.casco.repository;

import eu.banking.casco.model.Casco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CascoRepository extends PagingAndSortingRepository<Casco, Long>,
        JpaRepository<Casco, Long> {

    @Query("select c from Casco c where c.car.plateNumber = :plateNumber")
    Casco findByPlateNumber(String plateNumber);
}
