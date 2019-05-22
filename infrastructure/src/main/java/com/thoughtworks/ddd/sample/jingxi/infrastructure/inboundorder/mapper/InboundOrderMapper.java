package com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.mapper;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrder;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrderItem;
import com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.po.InboundOrderItemPo;
import com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.po.InboundOrderPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InboundOrderMapper {

    InboundOrderMapper MAPPER = Mappers.getMapper(InboundOrderMapper.class);

    @Mappings({
            @Mapping(target = "targetWarehouse.code", source = "targetWarehouse"),
            @Mapping(target = "supplier.code", source = "supplierCode"),
            @Mapping(target = "items", source = "items", qualifiedByName = "toItemPoList"),
            @Mapping(target = "auditingInfo.operator", source = "createdBy"),
            @Mapping(target = "auditingInfo.createdAt", source = "createdAt")
    })
    InboundOrder toOrder(InboundOrderPo po);

    @Mappings({
            @Mapping(target = "targetWarehouse", source = "targetWarehouse.code"),
            @Mapping(target = "supplierCode", source = "supplier.code"),
            @Mapping(target = "items", source = "items", qualifiedByName = "toItemList"),
            @Mapping(target = "createdBy", source = "auditingInfo.operator"),
            @Mapping(target = "createdAt", source = "auditingInfo.createdAt")
    })
    InboundOrderPo toOrderPo(InboundOrder order);


    InboundOrderItem toItemPo(InboundOrderItemPo po);

    InboundOrderItemPo toItem(InboundOrderItem item);

    List<InboundOrderItem> toItemPoList(List<InboundOrderItemPo> poList);

    List<InboundOrderItemPo> toItemList(List<InboundOrderItem> itemList);
}
