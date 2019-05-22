package com.thoughtworks.ddd.sample.jingxi.infrastructure.common;

import com.thoughtworks.ddd.sample.jingxi.domain.common.event.BaseEvent;
import com.thoughtworks.ddd.sample.jingxi.domain.common.publish.EventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationEventPublisher implements EventPublisher {

    @Override
    public void publish(BaseEvent event) {
        log.info("Published event: {}", event);
    }
}
