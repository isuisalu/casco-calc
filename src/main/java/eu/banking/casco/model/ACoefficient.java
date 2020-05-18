package eu.banking.casco.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class ACoefficient extends ABaseEntity {

    private String name;
    private BigDecimal value;
}
