package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.repository;

import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.Increment;
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.WarehouseStock;

import java.util.List;

public interface WarehouseStockRepository {

    WarehouseStock getOne(String warehouseCode);

    void store(WarehouseStock stock);

    /**
     * Repository implemantation way I : merge a new dto or vo to database
     * this is not a suggestion way.
     * If we have a lot of case, then we have to define a lot of method to update the database info.
     * @param increments
     */
    void merge(List<Increment> increments);
}
