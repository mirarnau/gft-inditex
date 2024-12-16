package com.gft_inditex.product_pricing_server.domain.exception;

import lombok.Getter;

import java.io.Serial;

@Getter
public class InvalidValueException extends RuntimeException {

    private static final String INVALID_PARAMETER = "Invalid parameter";

    @Serial
    private static final long serialVersionUID = -467269390479621172L;

    private final String message;
    private final String detailedMessage;

    public InvalidValueException(final String detailedMessage) {
        super(INVALID_PARAMETER);
        this.message = INVALID_PARAMETER;
        this.detailedMessage = detailedMessage;
    }

}