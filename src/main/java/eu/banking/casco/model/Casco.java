package eu.banking.casco.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class Casco extends ABaseEntity {

    private BigDecimal monthly;
    private BigDecimal annual;
    private Car car;
}
