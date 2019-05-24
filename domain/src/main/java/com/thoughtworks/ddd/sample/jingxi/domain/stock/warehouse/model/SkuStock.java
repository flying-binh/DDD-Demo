package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model;

import lombok.Getter;
import lombok.Setter;

import static java.math.BigInteger.ZERO;

@Getter
@Setter
public class SkuStock {

    private String sku;
    private Long inTransitQuantity;
    private Long physicalQuantity;

    public SkuStock(String sku, Long inTransitQuantity, Long physicalQuantity) {
        this.sku = sku;
        this.inTransitQuantity = inTransitQuantity;
        this.physicalQuantity = physicalQuantity;
    }

    public SkuStock(String sku) {
        this(sku, ZERO.longValue(), ZERO.longValue());
    }
}
