package com.thoughtworks.ddd.sample.jingxi.domain.common.auditing;

import lombok.Getter;
import lombok.Value;
import java.time.LocalDateTime;

@Value
@Getter
public class AuditingInfo {
    private String creator;
    private LocalDateTime createdAt;
}
