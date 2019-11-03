package com.thoughtworks.ddd.sample.jingxi.infrastructure.contract.po;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "payment_detail")
@NoArgsConstructor
public class PaymentDetailPo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fromAccount;
    private String toAccount;
    private double paymentAmount;
    private LocalDateTime paymentTime;
}
