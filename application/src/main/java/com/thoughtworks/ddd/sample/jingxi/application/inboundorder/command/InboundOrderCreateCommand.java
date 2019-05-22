package com.thoughtworks.ddd.sample.jingxi.application.inboundorder.command;

import com.thoughtworks.ddd.sample.jingxi.application.common.command.BaseCommand;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrderItem;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundType;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.ShipmentInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@EqualsAndHashCode(callSuper=false)
public class InboundOrderCreateCommand extends BaseCommand {

    private InboundType inboundType;
    private ShipmentInfo shipmentInfo;
    private String warehouseCode;
    private List<InboundOrderItem> items;
    private String supplierCode;

    public InboundOrderCreateCommand(InboundType inboundType,
                                     ShipmentInfo shipmentInfo,
                                     List<InboundOrderItem> items,
                                     String warehouseCode,
                                     String supplierCode,
                                     String operator,
                                     LocalDateTime triggerTime) {
        super(operator, triggerTime);
        this.inboundType = inboundType;
        this.shipmentInfo = shipmentInfo;
        this.warehouseCode = warehouseCode;
        this.supplierCode = supplierCode;
        this.items = items;
    }
}
