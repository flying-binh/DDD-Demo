package com.thoughtworks.ddd.sample.jingxi.domain.payment.event;

import com.thoughtworks.ddd.sample.jingxi.domain.common.event.BaseEvent;
import com.thoughtworks.ddd.sample.jingxi.domain.payment.model.PaymentDetail;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PaymentDetailCreatedEvent extends BaseEvent {
    private String fromAccount;
    private String toAccount;
    private double paymentAmount;
    private LocalDateTime paymentTime;

    public PaymentDetailCreatedEvent(PaymentDetail paymentDetail) {
        super(paymentDetail.getAuditingInfo() != null ? paymentDetail.getAuditingInfo().getOperator() : "system",
            paymentDetail.getAuditingInfo() != null ? paymentDetail.getAuditingInfo().getCreatedAt() : LocalDateTime.now());
        this.fromAccount = paymentDetail.getFromAccount();
        this.toAccount = paymentDetail.getToAccount();
        this.paymentAmount = paymentDetail.getPaymentAmount();
        this.paymentTime = paymentDetail.getPaymentTime();
    }
}
