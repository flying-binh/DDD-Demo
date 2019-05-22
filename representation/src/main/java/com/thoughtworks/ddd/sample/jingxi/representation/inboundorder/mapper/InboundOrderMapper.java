package com.thoughtworks.ddd.sample.jingxi.representation.inboundorder.mapper;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrderItem;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.ShipmentInfo;
import com.thoughtworks.ddd.sample.jingxi.representation.inboundorder.request.InboundOrderCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InboundOrderMapper {

    InboundOrderMapper MAPPER = Mappers.getMapper(InboundOrderMapper.class);

    InboundOrderItem toOrderItem(com.thoughtworks.ddd.sample.jingxi.representation.inboundorder.request.InboundOrderCreateRequest.InboundOrderItem item);

    List<InboundOrderItem> toOrderItems(List<InboundOrderCreateRequest.InboundOrderItem> item);

    ShipmentInfo toShipment(com.thoughtworks.ddd.sample.jingxi.representation.inboundorder.request.InboundOrderCreateRequest.ShipmentInfo shipmentInfo);

}
