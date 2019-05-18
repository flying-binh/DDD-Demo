package com.thoughtworks.ddd.sample.jingxi.representation.inboundorder;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InboundOrderCreateRequest {
    private String targetWarehouse;
    private InboundType type;
    private List<InboundOrderItem> items;
    private ShipmentInfo deliveryInfo;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ShipmentInfo {
        private String transactionNo;
        private LocalDate deliveryDate;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InboundOrderItem {
        private String skuCode;
        private String quantity;
    }

}
