package com.thoughtworks.ddd.sample.jingxi.application.inboundorder.mapper;

import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.dto.InboundOrderDto;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InboundOrderMapper {

    InboundOrderMapper MAPPER = Mappers.getMapper(InboundOrderMapper.class);

    InboundOrderDto toDto(InboundOrder inboundOrder);
}
