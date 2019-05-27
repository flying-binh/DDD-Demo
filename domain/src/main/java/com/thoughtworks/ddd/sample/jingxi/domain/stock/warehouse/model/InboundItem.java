package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model;

import lombok.Getter;

@Getter
public class InboundItem {
    private String sku;
    private Long quantity;

    public InboundItem(String sku, Long quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public InboundItem summary(InboundItem another) {
        assert sku.equals(another.getSku());
        this.quantity += another.quantity;
        return this;
    }
}
