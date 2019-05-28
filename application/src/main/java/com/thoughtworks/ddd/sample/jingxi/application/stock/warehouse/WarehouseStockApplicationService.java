package com.thoughtworks.ddd.sample.jingxi.application.stock.warehouse;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.event.InboundOrderSubmittedEvent;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrderItem;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.OrderStatus;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.InboundItem;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.InboundOrder;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.Increment;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.WarehouseStock;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.repository.WarehouseStockRepository;
import com.thoughtworks.ddd.sample.jingxi.domain.wms.event.SkuInboundedIntoWmsEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseStockApplicationService {
    private final WarehouseStockRepository warehouseStockRepository;

    @Autowired
    public WarehouseStockApplicationService(WarehouseStockRepository warehouseStockRepository) {
        this.warehouseStockRepository = warehouseStockRepository;
    }

    @EventListener
    public void listenInboundOrderSubmitted(InboundOrderSubmittedEvent event) {
        WarehouseStock stock = warehouseStockRepository.getOne(event.getWarehouseCode());
        registerSkus(stock, event.getItems());
        inbound(stock, event);
    }

    private void registerSkus(WarehouseStock warehouseStock, List<InboundOrderItem> inboundItemList) {
        warehouseStock.registerSkus(inboundItemList.stream().map(InboundOrderItem::getSkuCode).collect(Collectors.toSet()));

        warehouseStockRepository.store(warehouseStock);
    }

    private void inbound(WarehouseStock warehouseStock, InboundOrderSubmittedEvent event) {
        InboundOrder inboundOrder = new InboundOrder(event.getInboundOrderId(),
                event.getStatus(),
                event.getItems()
                        .stream()
                        .map(item -> new InboundItem(item.getSkuCode(), item.getQuantity()))
                        .collect(Collectors.toList()));
        List<Increment> increments = warehouseStock.inbound(inboundOrder);

        warehouseStockRepository.merge(increments);
    }

    @EventListener
    public void skuStockInWarehouse(SkuInboundedIntoWmsEvent event) {
        WarehouseStock stock = warehouseStockRepository.getOne(event.getWarehouse());
        InboundOrder inboundOrder = new InboundOrder(event.getTriggeredOrderId(),
                OrderStatus.COMPLATE,
                Collections.singletonList(new InboundItem(event.getSku(), event.getQuantity())));
        List<Increment> increments = stock.inbound(inboundOrder);
        
        warehouseStockRepository.merge(increments);
    }
}
