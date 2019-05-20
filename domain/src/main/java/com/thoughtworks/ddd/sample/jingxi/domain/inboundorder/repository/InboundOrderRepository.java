package com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.repository;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrder;

public interface InboundOrderRepository {

    InboundOrder store(InboundOrder inboundOrder);
}
