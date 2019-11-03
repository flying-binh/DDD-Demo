package com.thoughtworks.ddd.sample.jingxi.application.payment.mapper;

import com.thoughtworks.ddd.sample.jingxi.application.payment.dto.PaymentDetailDto;
import com.thoughtworks.ddd.sample.jingxi.domain.payment.model.PaymentDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedSourcePolicy = IGNORE)
public interface PaymentDetailMapper {
    PaymentDetailMapper MAPPER = Mappers.getMapper(PaymentDetailMapper.class);

    PaymentDetailDto toDto(PaymentDetail paymentDetail);
}
