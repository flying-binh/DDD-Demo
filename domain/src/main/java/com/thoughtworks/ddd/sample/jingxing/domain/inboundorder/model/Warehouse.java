package com.thoughtworks.ddd.sample.jingxing.domain.inboundorder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
@Builder
@AllArgsConstructor
public class Warehouse {
    private String code;
    private String name;
}

