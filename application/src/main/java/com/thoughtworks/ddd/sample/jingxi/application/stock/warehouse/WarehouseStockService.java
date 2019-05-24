package com.thoughtworks.ddd.sample.jingxi.application.stock.warehouse;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.event.InboundOrderSubmittedEvent;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrderItem;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.InboundItem;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.InboundOrder;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.Increment;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.WarehouseStock;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.repository.WarehouseStockRepository;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.service.SkuRegisterDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseStockService {
    private final WarehouseStockRepository warehouseStockRepository;

    @Autowired
    public WarehouseStockService(WarehouseStockRepository warehouseStockRepository) {
        this.warehouseStockRepository = warehouseStockRepository;
    }

    @EventListener
    public void listenInboundOrderSubmitted(InboundOrderSubmittedEvent event) {
        WarehouseStock stock = warehouseStockRepository.getOne(event.getWarehouseCode());
        registerSkus(stock, event.getItems());
        inbound(stock, event);
    }

    private void registerSkus(WarehouseStock warehouseStock, List<InboundOrderItem> inboundItemList) {
        SkuRegisterDomainService.registerSkusToWarehouse(warehouseStock,
                inboundItemList.stream().map(InboundOrderItem::getSkuCode).collect(Collectors.toSet()));

        warehouseStockRepository.store(warehouseStock);
    }

    private void inbound(WarehouseStock warehouseStock, InboundOrderSubmittedEvent event) {
        InboundOrder inboundOrder = new InboundOrder(event.getInboundOrderId(),
                event.getInboundType(),
                event.getItems()
                        .stream()
                        .map(item -> new InboundItem(item.getSkuCode(), item.getQuantity()))
                        .collect(Collectors.toList()));
        List<Increment> increments = warehouseStock.inbound(inboundOrder);

        warehouseStockRepository.merge(increments);
    }
}
