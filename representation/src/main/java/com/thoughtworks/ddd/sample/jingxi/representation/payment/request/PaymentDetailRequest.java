package com.thoughtworks.ddd.sample.jingxi.representation.payment.request;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(description = "payment detail  create request")
public class PaymentDetailRequest {
    private String fromAccount;
    private String toAccount;
    private double paymentAmount;
    private LocalDateTime paymentTime;
}
