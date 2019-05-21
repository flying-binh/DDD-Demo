package com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inbound_order_item")
public class InboundOrderItemPo {
    @Id
    @GeneratedValue
    private Long id;

    private String skuCode;

    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "inbound_order_id")
    private InboundOrderPo inboundOrder;
}
