package com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.event;

import com.thoughtworks.ddd.sample.jingxi.domain.common.event.BaseEvent;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrder;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundType;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.OrderStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class InboundOrderCreatedEvent extends BaseEvent {

    private Long inboundOrderId;
    private InboundType inboundType;
    private OrderStatus status;

    public InboundOrderCreatedEvent(InboundOrder inboundOrder) {
        super(inboundOrder.getAuditingInfo().getCreator(), LocalDateTime.now());
        this.inboundOrderId = inboundOrder.getId();
        this.inboundType = inboundOrder.getInboundType();
        this.status = inboundOrder.getStatus();
    }
}
