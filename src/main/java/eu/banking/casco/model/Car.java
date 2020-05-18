package eu.banking.casco.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public final class Car extends ABaseEntity {

    private String plateNumber;
    private Integer firstRegistration;
    private Integer purchasePrice;
    private String Producer;
    private Integer mileage;
    private BigDecimal previousIndemnity;
}
