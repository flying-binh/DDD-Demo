package com.thoughtworks.ddd.sample.jingxi.application.inboundorder;

import com.thoughtworks.ddd.sample.jingxi.application.common.publish.EventPublisher;
import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.command.InboundOrderCreateCommand;
import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.dto.InboundOrderDto;
import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.mapper.InboundOrderMapper;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.event.InboundOrderCreatedEvent;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.AuditingInfo;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrder;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.Supplier;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.Warehouse;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.repository.InboundOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class InboundOrderApplicationService {
    private final InboundOrderRepository inboundOrderRepository;
    private final EventPublisher eventPublisher;

    public InboundOrderApplicationService(InboundOrderRepository inboundOrderRepository,
                                          EventPublisher eventPublisher) {
        this.inboundOrderRepository = inboundOrderRepository;
        this.eventPublisher = eventPublisher;
    }

    public InboundOrderDto create(InboundOrderCreateCommand createCommand) {
        final InboundOrder order = new InboundOrder(
                Warehouse.builder().code(createCommand.getWarehouseCode()).build(),
                createCommand.getItems(),
                Supplier.builder().code(createCommand.getSupplierCode()).build(),
                createCommand.getShipmentInfo(),
                createCommand.getInboundType(),
                new AuditingInfo(createCommand.getOperator(), createCommand.getTriggerTime()));
        eventPublisher.publish(new InboundOrderCreatedEvent());
        return InboundOrderMapper.MAPPER.toDto(inboundOrderRepository.store(order));
    }
}
