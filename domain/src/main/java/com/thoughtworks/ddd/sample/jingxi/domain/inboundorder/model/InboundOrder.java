package com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model;

import com.thoughtworks.ddd.sample.jingxi.domain.common.auditing.AuditingInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class InboundOrder {
    private Long id;
    private Warehouse targetWarehouse;
    private List<InboundOrderItem> items;
    private ShipmentInfo shipmentInfo;
    private Supplier supplier;
    private InboundType inboundType;
    private OrderStatus status;
    private final OrderType type = OrderType.INBOUND;
    private AuditingInfo auditingInfo;

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
