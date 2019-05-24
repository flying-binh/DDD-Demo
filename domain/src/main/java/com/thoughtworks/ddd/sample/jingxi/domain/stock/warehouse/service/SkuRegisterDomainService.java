package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.service;

import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.WarehouseStock;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public final class SkuRegisterDomainService {

    public static void registerSkusToWarehouse(WarehouseStock warehouseStock, Set<String> skus) {
        assert warehouseStock != null;
        assert skus != null;

        warehouseStock.registerSkus(skus);
    }

}
