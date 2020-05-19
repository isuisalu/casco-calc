package eu.banking.casco.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
//@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class Casco {

    @Id
    @SequenceGenerator(name="casco_seq", initialValue=1, allocationSize=100)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="casco_seq")
    private Long id;

    @Column(name = "monthly", precision = 16, scale = 2)
    private BigDecimal monthly;
    @Column(name = "annual", precision = 16, scale = 2)
    private BigDecimal annual;
    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
}
