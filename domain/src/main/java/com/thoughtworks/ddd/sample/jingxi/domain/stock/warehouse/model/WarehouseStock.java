package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseStock {

    private String warehouse;
    private Set<SkuStock> skuStocks;

    public List<Increment> inbound(InboundOrder inboundOrder) {

        return Collections.emptyList();
    }

    public void outbound(OutboundOrder outbountOrder) {

    }

    public void registerSkus(Set<String> skus) {
        skus.stream()
                .filter(sku -> skuStocks.stream().allMatch(skuStock -> skuStock.getSku().equals(sku)))
                .map(SkuStock::new)
                .forEach(skuStock -> skuStocks.add(skuStock));
    }
}
