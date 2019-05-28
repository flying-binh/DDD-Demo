package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.OrderStatus;
import lombok.Getter;

import java.util.List;

@Getter
public class InboundOrder {
    private Long id;
    private OrderStatus status;
    private List<InboundItem> inboundItems;

    public InboundOrder(Long id,
                        OrderStatus status,
                        List<InboundItem> items) {
        this.id = id;
        this.status = status;
        inboundItems = items;
    }

}
