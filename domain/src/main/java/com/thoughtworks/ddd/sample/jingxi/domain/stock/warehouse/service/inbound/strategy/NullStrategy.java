package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.service.inbound.strategy;

import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.InboundItem;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.Increment;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.WarehouseStock;

import java.util.List;

public class NullStrategy implements InboundStrategy {
    @Override
    public List<Increment> inbound(WarehouseStock stock, List<InboundItem> inboundItems) {
        throw new UnsupportedOperationException("Unsupported inbound case.");
    }
}
