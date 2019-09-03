package com.thoughtworks.ddd.sample.jingxi.representation.configuration.security;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;
import java.util.Optional;

import static org.springframework.web.context.request.RequestAttributes.SCOPE_REQUEST;

public final class CurrentUser {

    public static String getCurrentUser() {
        return Optional.ofNullable(RequestContextHolder.currentRequestAttributes())
                .map(attr -> attr.getAttribute("operator", SCOPE_REQUEST))
                .filter(Objects::nonNull)
                .map(operator -> operator.toString())
                .orElse("None");
    }
}
