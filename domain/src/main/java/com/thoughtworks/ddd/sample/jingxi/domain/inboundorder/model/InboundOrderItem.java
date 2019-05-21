package com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InboundOrderItem {
    private Long id;
    private String skuCode;
    private Long quantity;
}
