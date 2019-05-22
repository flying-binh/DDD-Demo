package com.thoughtworks.ddd.sample.jingxi.domain.common.auditing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuditingInfo {
    private String operator;
    private LocalDateTime createdAt;
}
