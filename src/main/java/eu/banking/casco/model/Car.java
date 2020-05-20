package eu.banking.casco.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public final class Car extends ABaseEntity {

    @Column(name = "plate_number", nullable = false, unique = true)
    private String plateNumber;
    @Column(name ="first_registration", nullable = false)
    private Integer firstRegistration;
    @Column(name = "purchase_price", nullable = false)
    private Integer purchasePrice;
    @Column(name = "producer", nullable = false)
    private String producer;
    @Column(name = "mileage", nullable = false)
    private Integer mileage;
    @Column(name = "previous_indemnity", precision=7, scale = 2)
    private BigDecimal previousIndemnity;
}
