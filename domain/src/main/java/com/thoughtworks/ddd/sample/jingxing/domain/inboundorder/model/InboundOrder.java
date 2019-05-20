package com.thoughtworks.ddd.sample.jingxing.domain.inboundorder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class InboundOrder {
    private String id;
    private Warehouse targetWarehouse;
    private List<InboundOrderItem> items;
    private ShipmentInfo shipmentInfo;
    private Supplier supplier;

    @Builder.Default
    private OrderStatus status = OrderStatus.DRAFT;

    private AuditingInfo auditingInfo;

    public InboundOrder(Warehouse targetWarehouse,
                        List<InboundOrderItem> items,
                        Supplier supplier,
                        ShipmentInfo shipmentInfo,
                        AuditingInfo auditingInfo) {
        assert targetWarehouse != null;
        assert supplier != null;
        assert shipmentInfo != null;

        this.targetWarehouse = targetWarehouse;
        this.items = items;
        this.shipmentInfo = shipmentInfo;
        this.supplier = supplier;
        this.auditingInfo = auditingInfo;
    }
}
