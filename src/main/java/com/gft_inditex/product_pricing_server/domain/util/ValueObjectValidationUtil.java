package com.gft_inditex.product_pricing_server.domain.util;

import com.gft_inditex.product_pricing_server.domain.exception.EmptyValueException;
import com.gft_inditex.product_pricing_server.domain.exception.InvalidFormatValueException;
import com.gft_inditex.product_pricing_server.domain.exception.NegativeValueException;
import com.gft_inditex.product_pricing_server.domain.exception.NullValueException;

import java.util.Objects;

public class ValueObjectValidationUtil {

    private ValueObjectValidationUtil() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static void checkNonNullArgument(final Object value, final String fieldName) {
        if (Objects.isNull(value)) {
            throw new NullValueException(fieldName);
        }
    }

    public static void checkValidFormat(final String value, final String regex, final String fieldName) {
        if (!value.matches(regex)) {
            throw new InvalidFormatValueException(fieldName, value, regex);
        }
    }

    public static void checkIsNotEmpty(final String value, final String fieldName) {
        if (value.isEmpty()) {
            throw new EmptyValueException(fieldName);
        }
    }

    public static void checkIsNotNegative(final Number value, final String fieldName) {
        if (value.doubleValue() < 0) {
            throw new NegativeValueException(fieldName);
        }
    }

}
