package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.repository;

import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.Increment;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.WarehouseStock;

import java.util.List;

public interface WarehouseStockRepository {

    WarehouseStock getOne(String warehouseCode);

    void store(WarehouseStock stock);

    void merge(List<Increment> increments);
}
