package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.service.inbound.strategy;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.OrderStatus;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InboundStrategyFactory {

    private static final OrderSubmittedInboundStrategy SUBMITTED_INBOUND_STRATEGY = new OrderSubmittedInboundStrategy();
    private static final SkuStockedIntoWarehouseStrategy STOCKED_INTO_WAREHOUSE_STRATEGY = new SkuStockedIntoWarehouseStrategy();
    private static final NullStrategy NULL_STRATEGY = new NullStrategy();

    private static Map<OrderStatus, InboundStrategy> strategyMap = Stream.of(
            new AbstractMap.SimpleImmutableEntry<>(OrderStatus.SUBMITTED, SUBMITTED_INBOUND_STRATEGY),
            new AbstractMap.SimpleImmutableEntry<>(OrderStatus.COMPLATE, STOCKED_INTO_WAREHOUSE_STRATEGY))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static InboundStrategy getStrategy(OrderStatus orderStatus) {
        return strategyMap.getOrDefault(orderStatus, NULL_STRATEGY);
    }

}
