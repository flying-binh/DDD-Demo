package com.thoughtworks.ddd.sample.jingxi.domain.payment.repository;

import com.thoughtworks.ddd.sample.jingxi.domain.payment.model.PaymentDetail;

public interface PaymentDetailRepository {
    PaymentDetail create(PaymentDetail paymentDetail);
}
