package com.thoughtworks.ddd.sample.jingxi.application.payment.command;

import com.thoughtworks.ddd.sample.jingxi.application.common.command.BaseCommand;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(callSuper=false)
public class PaymentDetailCreateCommand extends BaseCommand {
    private String fromAccount;
    private String toAccount;
    private double paymentAmount;
    private LocalDateTime paymentTime;

    public PaymentDetailCreateCommand(String operator, LocalDateTime triggerTime, String fromAccount, String toAccount, double paymentAmount, LocalDateTime paymentTime) {
        super(operator, triggerTime);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.paymentAmount = paymentAmount;
        this.paymentTime = paymentTime;
    }
}
