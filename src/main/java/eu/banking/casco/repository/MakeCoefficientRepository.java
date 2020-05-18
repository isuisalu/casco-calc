package eu.banking.casco.repository;

import eu.banking.casco.model.MakeCoefficient;

import java.util.List;

public interface MakeCoefficientRepository {
    MakeCoefficient findByName(String name);
    List<MakeCoefficient> findAll();
    void save(MakeCoefficient make);
}
