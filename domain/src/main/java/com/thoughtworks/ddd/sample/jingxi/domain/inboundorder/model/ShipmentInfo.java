package com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model;

import lombok.Getter;
import lombok.Value;
import java.time.LocalDate;

@Getter
@Value
public class ShipmentInfo {
    private String transactionNo;
    private LocalDate deliveryDate;
}
