package com.gft_inditex.product_pricing_server.domain.exception;

import java.io.Serial;

public class NullValueException extends InvalidValueException {

    private static final String MESSAGE = "%s is null.";

    @Serial
    private static final long serialVersionUID = -467269390479621172L;

    public NullValueException(final String fieldName) {
        super(MESSAGE.formatted(fieldName));
    }

}
