package com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.event;

import com.thoughtworks.ddd.sample.jingxi.domain.common.event.BaseEvent;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrderItem;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundType;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.OrderStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class InboundOrderSubmittedEvent extends BaseEvent {

    private Long inboundOrderId;
    private InboundType inboundType;
    private String warehouseCode;
    private List<InboundOrderItem> items;
    private final OrderStatus status = OrderStatus.SUBMITTED;

    public InboundOrderSubmittedEvent(Long inboundOrderId,
                                      InboundType inboundType,
                                      String warehouseCode,
                                      List<InboundOrderItem> items,
                                      String operator,
                                      LocalDateTime occurredTime) {
        super(operator, occurredTime);
        this.inboundOrderId = inboundOrderId;
        this.inboundType = inboundType;
        this.items = items;
        this.warehouseCode = warehouseCode;
    }
}
