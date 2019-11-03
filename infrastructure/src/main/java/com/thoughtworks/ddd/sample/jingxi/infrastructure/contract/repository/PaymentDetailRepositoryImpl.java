package com.thoughtworks.ddd.sample.jingxi.infrastructure.contract.repository;

import com.thoughtworks.ddd.sample.jingxi.domain.payment.model.PaymentDetail;
import com.thoughtworks.ddd.sample.jingxi.domain.payment.repository.PaymentDetailRepository;
import com.thoughtworks.ddd.sample.jingxi.infrastructure.contract.mapper.PaymentDetailMapper;
import com.thoughtworks.ddd.sample.jingxi.infrastructure.contract.po.PaymentDetailPo;
import com.thoughtworks.ddd.sample.jingxi.infrastructure.contract.repository.jpa.PaymentDetailJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.ref.PhantomReference;

@Component
public class PaymentDetailRepositoryImpl implements PaymentDetailRepository {

    private PaymentDetailJpaRepository paymentDetailJpaRepository;

    private PaymentDetailMapper paymentDetailMapper;

    public PaymentDetailRepositoryImpl(PaymentDetailJpaRepository paymentDetailJpaRepository) {
        this.paymentDetailJpaRepository = paymentDetailJpaRepository;
        this.paymentDetailMapper = PaymentDetailMapper.MAPPER;
    }

    @Override
    public PaymentDetail create(PaymentDetail paymentDetail) {
        PaymentDetailPo paymentDetailPo = paymentDetailMapper.toPaymentDetailPo(paymentDetail);
        return paymentDetailMapper.toPaymentDetail(paymentDetailJpaRepository.save(paymentDetailPo));
    }
}
