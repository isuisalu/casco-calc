package eu.banking.casco.repository;

import eu.banking.casco.model.MakeCoefficient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakeCoefficientRepository
        extends JpaRepository<MakeCoefficient, Long> {
    MakeCoefficient findByName(String name);
}

