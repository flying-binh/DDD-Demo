package com.thoughtworks.ddd.sample.jingxi.application.payment;

import com.thoughtworks.ddd.sample.jingxi.application.payment.command.PaymentDetailCreateCommand;
import com.thoughtworks.ddd.sample.jingxi.application.payment.dto.PaymentDetailDto;
import com.thoughtworks.ddd.sample.jingxi.application.payment.mapper.PaymentDetailMapper;
import com.thoughtworks.ddd.sample.jingxi.domain.common.auditing.AuditingInfo;
import com.thoughtworks.ddd.sample.jingxi.domain.common.publish.EventPublisher;
import com.thoughtworks.ddd.sample.jingxi.domain.payment.event.PaymentDetailCreatedEvent;
import com.thoughtworks.ddd.sample.jingxi.domain.payment.model.PaymentDetail;
import com.thoughtworks.ddd.sample.jingxi.domain.payment.repository.PaymentDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentDetailApplicationService {
    private final PaymentDetailRepository paymentDetailRepository;
    private final EventPublisher eventPublisher;

    public PaymentDetailApplicationService(PaymentDetailRepository paymentDetailRepository, EventPublisher eventPublisher) {
        this.paymentDetailRepository = paymentDetailRepository;
        this.eventPublisher = eventPublisher;
    }

    public PaymentDetailDto create(PaymentDetailCreateCommand createCommand) {
        final PaymentDetail order = paymentDetailRepository.create(commandToPaymentDetail(createCommand));
        eventPublisher.publish(new PaymentDetailCreatedEvent(order));
        return PaymentDetailMapper.MAPPER.toDto(order);
    }

    private PaymentDetail commandToPaymentDetail(PaymentDetailCreateCommand createCommand) {
        return new PaymentDetail(
            createCommand.getFromAccount(),
            createCommand.getToAccount(),
            createCommand.getPaymentAmount(),
            createCommand.getPaymentTime(),
            new AuditingInfo(createCommand.getOperator(), createCommand.getTriggerTime()));
    }
}
