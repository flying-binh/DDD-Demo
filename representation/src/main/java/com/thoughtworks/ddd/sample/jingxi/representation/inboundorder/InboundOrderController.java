package com.thoughtworks.ddd.sample.jingxi.representation.inboundorder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/inbound-orders")
@Api(value = "inbound order api")
public class InboundOrderController {

    @PostMapping
    @ApiOperation(value = "create", nickname = "create-inbound-order", notes = "create an inbound order")
    public ResponseEntity<InboundOrderCreatedResponse> create(@RequestBody @Valid InboundOrderCreateRequest request) {
        return ResponseEntity.ok(new InboundOrderCreatedResponse(UUID.randomUUID().toString()));
    }
}
