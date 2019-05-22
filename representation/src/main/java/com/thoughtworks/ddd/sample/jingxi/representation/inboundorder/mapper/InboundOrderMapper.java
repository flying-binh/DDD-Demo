package com.thoughtworks.ddd.sample.jingxi.representation.inboundorder.mapper;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrderItem;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.ShipmentInfo;
import com.thoughtworks.ddd.sample.jingxi.representation.inboundorder.InboundOrderCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InboundOrderMapper {

    InboundOrderMapper MAPPER = Mappers.getMapper(InboundOrderMapper.class);

    List<InboundOrderItem> toOrderItems(List<InboundOrderCreateRequest.InboundOrderItem> item);

    ShipmentInfo toShipment(com.thoughtworks.ddd.sample.jingxi.representation.inboundorder.InboundOrderCreateRequest.ShipmentInfo shipmentInfo);

}
