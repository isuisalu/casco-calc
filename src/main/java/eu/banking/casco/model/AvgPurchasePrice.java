package eu.banking.casco.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class AvgPurchasePrice  extends ABaseEntity {

    private String producer;
    private BigDecimal price;
}
