package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.service.inbound.strategy;

import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.InboundItem;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.Increment;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.WarehouseStock;

import java.util.List;

public interface InboundStrategy {

    List<Increment> inbound(WarehouseStock stock, List<InboundItem> inboundItems);
}
