package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.service.inbound.strategy;

import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.InboundItem;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.Increment;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.WarehouseStock;

import java.util.List;
import java.util.stream.Collectors;

import static java.math.BigInteger.ZERO;

public class OrderSubmittedInboundStrategy {

    public List<Increment> inbound(WarehouseStock stock, List<InboundItem> inboundItems) {
        return inboundItems.stream()
                .map(item -> new Increment(stock.getWarehouse(),
                        item.getSku(),
                        item.getQuantity(),
                        ZERO.longValue()))
                .collect(Collectors.toList());
    }

}
