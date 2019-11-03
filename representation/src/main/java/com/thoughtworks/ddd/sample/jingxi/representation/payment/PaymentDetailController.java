package com.thoughtworks.ddd.sample.jingxi.representation.payment;

import com.thoughtworks.ddd.sample.jingxi.application.payment.PaymentDetailApplicationService;
import com.thoughtworks.ddd.sample.jingxi.application.payment.command.PaymentDetailCreateCommand;
import com.thoughtworks.ddd.sample.jingxi.application.payment.dto.PaymentDetailDto;
import com.thoughtworks.ddd.sample.jingxi.representation.configuration.security.CurrentUser;
import com.thoughtworks.ddd.sample.jingxi.representation.payment.request.PaymentDetailRequest;
import com.thoughtworks.ddd.sample.jingxi.representation.payment.response.PaymentDetailResponse;
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
@RequestMapping("/payments")
@Api(value = "Payment detail api")
public class PaymentDetailController {
    private final PaymentDetailApplicationService applicationService;

    @Autowired
    public PaymentDetailController(PaymentDetailApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    @ApiOperation(value = "create", nickname = "create-payment-details", notes = "create an payment detail")
    public ResponseEntity<PaymentDetailResponse> create(@RequestBody @Valid PaymentDetailRequest request) {
        PaymentDetailDto order = applicationService.create(new PaymentDetailCreateCommand(
            CurrentUser.getCurrentUser(),
            LocalDateTime.now(),
            request.getFromAccount(),
            request.getToAccount(),
            request.getPaymentAmount(),
            request.getPaymentTime()
        ));
        return ResponseEntity.ok(new PaymentDetailResponse(order.getId().toString()));
    }
}
