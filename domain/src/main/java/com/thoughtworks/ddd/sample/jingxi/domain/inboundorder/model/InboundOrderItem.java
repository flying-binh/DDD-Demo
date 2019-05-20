package com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class InboundOrderItem {
    private String skuCode;
    private Long quantity;
}
