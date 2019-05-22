package com.thoughtworks.ddd.sample.jingxi.representation.inboundorder;

import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.InboundOrderApplicationService;
import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.command.InboundOrderCreateCommand;
import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.dto.InboundOrderDto;
import com.thoughtworks.ddd.sample.jingxi.representation.configuration.security.CurrentUser;
import com.thoughtworks.ddd.sample.jingxi.representation.inboundorder.mapper.InboundOrderMapper;
import com.thoughtworks.ddd.sample.jingxi.representation.inboundorder.request.InboundOrderCreateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/inbound-orders")
@Api(value = "inbound order api")
public class InboundOrderController {

    private final InboundOrderApplicationService applicationService;

    @Autowired
    public InboundOrderController(InboundOrderApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    @ApiOperation(value = "create", nickname = "create-inbound-order", notes = "create an inbound order")
    public ResponseEntity<InboundOrderCreatedResponse> create(@RequestBody @Valid InboundOrderCreateRequest request) {
        InboundOrderDto order = applicationService.create(new InboundOrderCreateCommand(
                request.getType(),
                InboundOrderMapper.MAPPER.toShipment(request.getShipmentInfo()),
                InboundOrderMapper.MAPPER.toOrderItems(request.getItems()),
                request.getTargetWarehouse(),
                request.getSupplierCode(),
                CurrentUser.getCurrentUser(),
                LocalDateTime.now()));
        return ResponseEntity.ok(new InboundOrderCreatedResponse(order.getId()));
    }
}
