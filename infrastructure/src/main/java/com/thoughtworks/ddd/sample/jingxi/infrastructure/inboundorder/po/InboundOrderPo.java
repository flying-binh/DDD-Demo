package com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.po;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundType;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.OrderType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "inbound_order")
public class InboundOrderPo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private InboundType inboundType;
    private OrderType orderType;
    private String targetWarehouse;
    private String supplierCode;
    private String createdBy;
    private LocalDateTime createdAt;
}
