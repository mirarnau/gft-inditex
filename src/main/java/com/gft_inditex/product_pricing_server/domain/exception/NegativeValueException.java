package com.gft_inditex.product_pricing_server.domain.exception;

import java.io.Serial;

public class NegativeValueException extends InvalidValueException {

    private static final String MESSAGE = "%s must not be a negative value";

    @Serial
    private static final long serialVersionUID = -467269390179621559L;

    public NegativeValueException(final String fieldName) {
        super(MESSAGE.formatted(fieldName));
    }

}
