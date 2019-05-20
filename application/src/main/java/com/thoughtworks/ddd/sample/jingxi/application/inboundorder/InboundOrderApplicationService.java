package com.thoughtworks.ddd.sample.jingxi.application.inboundorder;

import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.command.InboundOrderCreateCommand;
import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.dto.InboundOrderDto;
import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.mapper.InboundOrderMapper;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.AuditingInfo;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrder;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.repository.InboundOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class InboundOrderApplicationService {
    private final InboundOrderRepository inboundOrderRepository;

    public InboundOrderApplicationService(InboundOrderRepository inboundOrderRepository) {
        this.inboundOrderRepository = inboundOrderRepository;
    }

    public InboundOrderDto create(InboundOrderCreateCommand createCommand) {
        final InboundOrder order = new InboundOrder(
                createCommand.getWarehouse(),
                createCommand.getItems(),
                createCommand.getSupplier(),
                createCommand.getShipmentInfo(),
                createCommand.getInboundType(),
                new AuditingInfo(createCommand.getOperator(), createCommand.getTriggerTime()));

        return InboundOrderMapper.MAPPER.toDto(inboundOrderRepository.store(order));
    }
}
