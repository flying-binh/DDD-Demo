package com.thoughtworks.ddd.sample.jingxi.representation.inboundorder;

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(description = "inbound order create request")
public class InboundOrderCreateRequest {

    @ApiModelProperty(notes = "inbound target warehouse code", required = true)
    @NotBlank
    private String targetWarehouse;

    @ApiModelProperty(notes = "inbound type: PURCHASE/ALLOCATION", required = true)
    @NotBlank
    private InboundType type;

    @ApiModelProperty(notes = "inbound order items", required = true)
    @NotEmpty
    private List<InboundOrderItem> items;

    @ApiModelProperty(notes = "shipment information")
    private ShipmentInfo shipmentInfo;

    @ApiModelProperty(notes = "supplier code")
    private String supplierCode;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(description = "inbound order item")
    public static class InboundOrderItem {

        @ApiModelProperty(notes = "sku code for inbound", required = true)
        @NotBlank
        private String skuCode;

        @ApiModelProperty(notes = "inbound sku quantity", required = true)
        @NotNull
        @Size(max = 10000, min = -10000)
        private Long quantity;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(description = "shipment information")
    public static class ShipmentInfo {

        @ApiModelProperty(notes = "transaction number")
        private String transactionNo;

        @ApiModelProperty(notes = "delivery date")
        private LocalDate deliveryDate;
    }
}
