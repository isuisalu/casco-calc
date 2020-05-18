package eu.banking.casco.repository;

import eu.banking.casco.model.RiskCoefficient;

import java.util.List;

public interface RiskCoefficientRepository {

    String VEHICLE_AGE_RISK = "vehicle_age";
    String VEHICLE_VALUE_RISK = "vehicle_value";
    String PREVIOUS_INDEMNITY_RISK = "previous_indemnity";

    RiskCoefficient findByName(String name);
    List<RiskCoefficient> findAll();
    void save(RiskCoefficient risk);
}
