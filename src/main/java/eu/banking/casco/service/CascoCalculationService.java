package eu.banking.casco.service;

import eu.banking.casco.model.Car;

import java.math.BigDecimal;

public interface CascoCalculationService {
    BigDecimal computeAnnualCasco(Car car);
    void reCalculateCascos();
}
