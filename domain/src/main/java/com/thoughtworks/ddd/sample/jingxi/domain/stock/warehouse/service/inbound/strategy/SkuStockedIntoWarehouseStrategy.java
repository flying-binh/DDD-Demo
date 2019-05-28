package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.service.inbound.strategy;

import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.InboundItem;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.Increment;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.WarehouseStock;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The sku(product) stocked into warehouse, and the wms system published
 * and SkuStockedIn event.
 * then we need to
 * (1) increase the sku physical quantity
 * and
 * (2) decrease the in transit quantity
 */
public class SkuStockedIntoWarehouseStrategy implements InboundStrategy {

    @Override
    public List<Increment> inbound(WarehouseStock stock, List<InboundItem> inboundItems) {
        return inboundItems.stream()
                .map(item -> new Increment(stock.getWarehouse(),
                        item.getSku(),
                        -item.getQuantity(),
                        item.getQuantity()))
                .collect(Collectors.toList());
    }
}
