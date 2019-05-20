package com.thoughtworks.ddd.sample.jingxi.application.inboundorder;

import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.command.InboundOrderCreateCommand;
import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.dto.InboundOrderDto;
import com.thoughtworks.ddd.sample.jingxing.domain.inboundorder.model.OrderStatus;
import java.util.UUID;

public class InboundOrderApplicationService {
    public InboundOrderDto create(InboundOrderCreateCommand createCommand) {
        return new InboundOrderDto(UUID.randomUUID().toString(), OrderStatus.DRAFT);
    }
}
