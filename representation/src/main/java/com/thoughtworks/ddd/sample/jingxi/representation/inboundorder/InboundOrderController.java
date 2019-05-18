package com.thoughtworks.ddd.sample.jingxi.representation.inboundorder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/inbound-orders")
public class InboundOrderController {

    @PostMapping
    public ResponseEntity<InboundOrderCreatedResponse> create(@RequestBody @Valid InboundOrderCreateRequest request) {
        return ResponseEntity.ok(new InboundOrderCreatedResponse(UUID.randomUUID().toString()));
    }
}
