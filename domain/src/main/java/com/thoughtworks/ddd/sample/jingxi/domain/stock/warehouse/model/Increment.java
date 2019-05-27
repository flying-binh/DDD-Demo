package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Increment {
    private String warehouse;
    private String sku;
    private Long inTransitQuantity;
    private Long physicalQuantity;
}
