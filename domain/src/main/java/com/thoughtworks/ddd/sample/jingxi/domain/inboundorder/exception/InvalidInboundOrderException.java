package com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.exception;

public class InvalidInboundOrderException extends RuntimeException {

    public InvalidInboundOrderException(String message) {
        super(message);
    }

}
