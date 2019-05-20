package com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
@Builder
@AllArgsConstructor
public class Supplier {
    private String name;
    private String code;
}
