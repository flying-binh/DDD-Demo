package com.thoughtworks.ddd.sample.jingxi.application.inboundorder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InboundOrderDto {
    private String id;
    private OrderStatus status;
}
