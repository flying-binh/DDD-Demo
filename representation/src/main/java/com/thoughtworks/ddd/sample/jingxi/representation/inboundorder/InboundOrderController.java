package com.thoughtworks.ddd.sample.jingxi.representation.inboundorder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inbound-orders")
public class InboundOrderController {

    @PostMapping
    public ResponseEntity<CreatedInboundOrderResponse> create() {
        return ResponseEntity.ok().build();
    }
}
