package com.thoughtworks.ddd.sample.jingxi.infrastructure.contract.mapper;

import com.thoughtworks.ddd.sample.jingxi.domain.payment.model.PaymentDetail;
import com.thoughtworks.ddd.sample.jingxi.infrastructure.contract.po.PaymentDetailPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentDetailMapper {

    PaymentDetailMapper MAPPER = Mappers.getMapper(PaymentDetailMapper.class);

    @Mappings({})
    PaymentDetail toPaymentDetail(PaymentDetailPo paymentDetailPo);

    @Mappings({})
    PaymentDetailPo toPaymentDetailPo(PaymentDetail paymentDetail);
}
