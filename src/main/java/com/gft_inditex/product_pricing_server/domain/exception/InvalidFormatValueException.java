package com.gft_inditex.product_pricing_server.domain.exception;

import java.io.Serial;

public class InvalidFormatValueException extends InvalidValueException {

    protected static final String MESSAGE = "%s format is invalid. %s does not comply with %s regex.";

    @Serial
    private static final long serialVersionUID = -6929640766597124795L;

    public InvalidFormatValueException(final String field, final String value, final String regex) {
        super(MESSAGE.formatted(field, value, regex));
    }

}
