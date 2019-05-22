package com.thoughtworks.ddd.sample.jingxi.domain.common.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BaseEvent {

    private String operator;
    private LocalDateTime occurredTime;
}
