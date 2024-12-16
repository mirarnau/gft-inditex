package com.gft_inditex.product_pricing_server.domain.exception;

import java.io.Serial;

public class EmptyValueException extends InvalidValueException {

    private static final String MESSAGE = "%s must not be empty";

    @Serial
    private static final long serialVersionUID = -467299390479681175L;

    public EmptyValueException(final String fieldName) {
        super(MESSAGE.formatted(fieldName));
    }

}
