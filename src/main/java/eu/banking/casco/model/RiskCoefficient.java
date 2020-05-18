package eu.banking.casco.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public final class RiskCoefficient extends ACoefficient {

    private Boolean inUse;
}
