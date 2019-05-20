package com.thoughtworks.ddd.sample.jingxing.domain.inboundorder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
@AllArgsConstructor
public class InboundOrderItem {
    private String skuCode;
    private String quantity;
}
