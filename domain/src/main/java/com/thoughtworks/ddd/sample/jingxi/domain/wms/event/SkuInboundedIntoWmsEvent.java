package com.thoughtworks.ddd.sample.jingxi.domain.wms.event;

import com.thoughtworks.ddd.sample.jingxi.domain.common.event.BaseEvent;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SkuInboundedIntoWmsEvent extends BaseEvent {

    private Long triggeredOrderId;
    private String warehouse;
    private String sku;
    private Long quantity;

    public SkuInboundedIntoWmsEvent(Long triggeredOrderId,
                                    String warehouse,
                                    String sku,
                                    Long quantity,
                                    LocalDateTime occurredTime) {
        super("WMS", occurredTime);
        this.triggeredOrderId = triggeredOrderId;
        this.warehouse = warehouse;
        this.sku = sku;
        this.quantity = quantity;
    }
}
