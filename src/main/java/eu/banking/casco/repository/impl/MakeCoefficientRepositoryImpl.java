package eu.banking.casco.repository.impl;

import eu.banking.casco.model.MakeCoefficient;
import eu.banking.casco.model.RiskCoefficient;
import eu.banking.casco.repository.MakeCoefficientRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MakeCoefficientRepositoryImpl implements MakeCoefficientRepository {
    private Map<String, MakeCoefficient> makeCoefficientMap = new HashMap<>();
    @Override
    public MakeCoefficient findByName(String name) {
        return makeCoefficientMap.get(name);
    }

    @Override
    public List<MakeCoefficient> findAll() {
        return new ArrayList<>(makeCoefficientMap.values());
    }

    @Override
    public void save(MakeCoefficient make) {
        makeCoefficientMap.put(make.getName(), make);
    }
}
