package com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.repository;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrder;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.repository.InboundOrderRepository;
import com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.mapper.InboundOrderMapper;
import com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.po.InboundOrderPo;
import com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.repository.jpa.InboundOrderJapRepository;
import org.springframework.stereotype.Component;

@Component
public class InboundOrderRepositoryImpl implements InboundOrderRepository {

    private final InboundOrderJapRepository inboundOrderJapRepository;
    private final InboundOrderMapper orderMapper;

    public InboundOrderRepositoryImpl(InboundOrderJapRepository inboundOrderJapRepository) {
        this.inboundOrderJapRepository = inboundOrderJapRepository;
        orderMapper = InboundOrderMapper.MAPPER;
    }

    @Override
    public InboundOrder store(InboundOrder inboundOrder) {
        InboundOrderPo po = orderMapper.toOrderPo(inboundOrder);
        return orderMapper.toOrder(inboundOrderJapRepository.save(po));
    }
}
