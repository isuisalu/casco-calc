package eu.banking.casco.repository;

import eu.banking.casco.model.AvgPurchasePrice;

import java.util.List;

public interface AvgPurchasePriceRepository {

    AvgPurchasePrice findByProducer(String producer);
    List<AvgPurchasePrice> findAll();
    void save(AvgPurchasePrice price);
}
