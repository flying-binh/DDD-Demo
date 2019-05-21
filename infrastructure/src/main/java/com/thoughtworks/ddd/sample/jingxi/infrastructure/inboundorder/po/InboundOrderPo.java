package com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.po;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundType;
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.OrderType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "inbound_order")
@NoArgsConstructor
public class InboundOrderPo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private InboundType inboundType;
    private OrderType orderType;
    private String targetWarehouse;
    private String supplierCode;
    private String createdBy;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "inboundOrder", cascade = CascadeType.ALL)
    private Set<InboundOrderItemPo> items;
}
