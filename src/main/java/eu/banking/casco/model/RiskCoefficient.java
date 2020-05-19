package eu.banking.casco.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public final class RiskCoefficient extends ACoefficient {

    @Column(name = "in_use", columnDefinition = "BOOLEAN")
    private Boolean inUse;
}
