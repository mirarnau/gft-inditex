package com.gft_inditex.product_pricing_server.domain.valueobject;

import com.gft_inditex.product_pricing_server.domain.util.ValueObjectValidationUtil;

import java.time.LocalDateTime;

public class Date implements ValueObject<LocalDateTime> {

    private static final String DATE_REGEX = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])T([01]\\d|2[0-3]):([0-5]\\d)(:([0-5]\\d))?$";

    private final LocalDateTime value;

    protected Date(final String value, final String subClassName) {
        validate(value, subClassName);
        this.value = LocalDateTime.parse(value);
    }

    private void validate(final String value, final String subClassName) {
        ValueObjectValidationUtil.checkNonNullArgument(value, subClassName);
        ValueObjectValidationUtil.checkIsNotEmpty(value, subClassName);
        ValueObjectValidationUtil.checkValidFormat(value, DATE_REGEX, subClassName);
    }

    @Override
    public LocalDateTime value() {
        return value;
    }

}
