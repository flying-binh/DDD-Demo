package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseStock {

    private String warehouse;
    private Set<SkuStock> skuStocks;

    public List<Increment> inbound(InboundOrder inboundOrder) {

        Map<String, InboundItem> items = inboundOrder.getInboundItems()
                .stream()
                .collect(groupingBy(InboundItem::getSku))
                .values()
                .stream()
                .map(inboundItems -> inboundItems.stream().reduce(InboundItem::summary))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toMap(InboundItem::getSku, Function.identity()));

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
