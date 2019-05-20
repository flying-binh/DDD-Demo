package com.thoughtworks.ddd.sample.jingxi.application.inboundorder.command;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrderItem;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundType;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.ShipmentInfo;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.Supplier;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.Warehouse;
import lombok.Getter;
import lombok.Value;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Value
public class InboundOrderCreateCommand {

    private InboundType inboundType;
    private ShipmentInfo shipmentInfo;
    private Warehouse warehouse;
    private List<InboundOrderItem> items;
    private Supplier supplier;

    private String operator;
    private LocalDateTime triggerTime;
}
