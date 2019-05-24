package com.thoughtworks.ddd.sample.jingxi.domain.stock.wms.event;

import com.thoughtworks.ddd.sample.jingxi.domain.common.event.BaseEvent;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SkuInboundedIntoWmsEvent extends BaseEvent {

    private String warehouse;
    private String sku;
    private String quantity;

    public SkuInboundedIntoWmsEvent(LocalDateTime occurredTime) {
        super("WMS", occurredTime);
    }
}
