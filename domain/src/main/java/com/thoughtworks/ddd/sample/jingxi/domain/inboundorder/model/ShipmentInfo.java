package com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import java.time.LocalDate;

@Getter
@Value
@AllArgsConstructor
public class ShipmentInfo {
    private String transactionNo;
    private LocalDate deliveryDate;
}
