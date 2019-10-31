package com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.repository;

import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.Increment;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.WarehouseStock;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.repository.WarehouseStockRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WarehouseStockRepositoryImpl implements WarehouseStockRepository {
    @Override
    public WarehouseStock getOne(String warehouseCode) {
        return null;
    }

    @Override
    public void store(WarehouseStock stock) {

    }

    @Override
    public void merge(List<Increment> increments) {

    }
}
