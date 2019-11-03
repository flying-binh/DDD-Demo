package com.thoughtworks.ddd.sample.jingxi.domain.payment.model;

import com.thoughtworks.ddd.sample.jingxi.domain.common.auditing.AuditingInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PaymentDetail {
    private Long id;
    private String fromAccount;
    private String toAccount;
    private double paymentAmount;
    private LocalDateTime paymentTime;
    private AuditingInfo auditingInfo;

    public PaymentDetail(String fromAccount, String toAccount, double paymentAmount, LocalDateTime paymentTime, AuditingInfo auditingInfo) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.paymentAmount = paymentAmount;
        this.paymentTime = paymentTime;
        this.auditingInfo = auditingInfo;
    }
}
