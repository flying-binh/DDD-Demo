package com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.mapper;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrder;
import com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.po.InboundOrderPo;

public interface InboundOrderMapper {

    InboundOrder toDomain(InboundOrderPo po);

    InboundOrderPo toPo(InboundOrder order);
}
