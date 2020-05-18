package eu.banking.casco.repository.impl;

import eu.banking.casco.model.RiskCoefficient;
import eu.banking.casco.repository.RiskCoefficientRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RiskCoefficientRepositoryImpl
        implements RiskCoefficientRepository {
    private Map<String, RiskCoefficient> risks = new HashMap<>();
    @Override
    public RiskCoefficient findByName(String name) {
        return risks.get(name);
    }

    @Override
    public List<RiskCoefficient> findAll() {
        return new ArrayList<>(risks.values());
    }

    @Override
    public void save(RiskCoefficient risk) {
        risks.put(risk.getName(), risk);
    }
}
