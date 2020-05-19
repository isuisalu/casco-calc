package eu.banking.casco.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class ACoefficient extends ABaseEntity {

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name ="value", nullable = false, precision=7, scale = 2)
    private BigDecimal value;
}
