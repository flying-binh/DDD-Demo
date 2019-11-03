package com.thoughtworks.ddd.sample.jingxi.representation.payment.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class PaymentDetailResponse {
    String id;

    public PaymentDetailResponse(String id) {
        this.id = id;
    }
}
