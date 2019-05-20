package com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class InboundOrder {
    private String id;
    private Warehouse targetWarehouse;
    private List<InboundOrderItem> items;
    private ShipmentInfo shipmentInfo;
    private Supplier supplier;
    private AuditingInfo auditingInfo;
    private InboundType inboundType;
    private OrderStatus status;
    private final OrderType type = OrderType.INBOUND;

    public InboundOrder(Warehouse targetWarehouse,
                        List<InboundOrderItem> items,
                        Supplier supplier,
                        ShipmentInfo shipmentInfo,
                        InboundType inboundType,
                        AuditingInfo auditingInfo) {
        assert targetWarehouse != null;
        assert supplier != null;
        assert shipmentInfo != null;
        assert items != null && !items.isEmpty();

        this.targetWarehouse = targetWarehouse;
        this.items = items;
        this.shipmentInfo = shipmentInfo;
        this.supplier = supplier;
        this.inboundType = inboundType;
        this.status = OrderStatus.DRAFT;
        this.auditingInfo = auditingInfo;
    }
}
