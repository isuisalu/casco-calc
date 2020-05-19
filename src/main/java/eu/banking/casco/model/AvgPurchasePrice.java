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
@Table(name = "avg_purchase_price")
public class AvgPurchasePrice  extends ABaseEntity {

    @Column(name = "producer", nullable = false)
    private String producer;
    @Column(name = "previous_indemnity", nullable = false, precision=5, scale = 0)
    private BigDecimal price;
}
