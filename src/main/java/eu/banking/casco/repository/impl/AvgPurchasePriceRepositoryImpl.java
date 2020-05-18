package eu.banking.casco.repository.impl;

import eu.banking.casco.model.AvgPurchasePrice;
import eu.banking.casco.model.MakeCoefficient;
import eu.banking.casco.repository.AvgPurchasePriceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AvgPurchasePriceRepositoryImpl
        implements AvgPurchasePriceRepository {
    private Map<String, AvgPurchasePrice> prices = new HashMap<>();

    @Override
    public AvgPurchasePrice findByProducer(String producer) {
        return prices.get(producer);
    }

    public List<AvgPurchasePrice> findAll() {
        return new ArrayList<>(prices.values());
    }

    @Override
    public void save(AvgPurchasePrice price) {
        prices.put(price.getProducer(), price);
    }
}
