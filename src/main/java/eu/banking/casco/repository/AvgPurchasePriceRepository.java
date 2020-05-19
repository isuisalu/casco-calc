package eu.banking.casco.repository;

import eu.banking.casco.model.AvgPurchasePrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvgPurchasePriceRepository
        extends JpaRepository<AvgPurchasePrice, Long> {

    AvgPurchasePrice findByProducer(String producer);
}

