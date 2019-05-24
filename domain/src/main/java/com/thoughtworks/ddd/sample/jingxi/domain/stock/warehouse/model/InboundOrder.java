package com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundType;
import lombok.Getter;

import java.util.List;

@Getter
public class InboundOrder {
    private Long id;
    private InboundType inboundType;

    private List<InboundItem> inboundItems;

    public InboundOrder(Long id,
                        InboundType inboundType,
                        List<InboundItem> items) {
        this.id = id;
        this.inboundType = inboundType;
        inboundItems = items;
    }

}
