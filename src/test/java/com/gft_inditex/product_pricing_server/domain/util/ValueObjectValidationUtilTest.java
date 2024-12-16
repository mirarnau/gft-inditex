package com.gft_inditex.product_pricing_server.domain.util;

import com.gft_inditex.product_pricing_server.domain.exception.EmptyValueException;
import com.gft_inditex.product_pricing_server.domain.exception.InvalidFormatValueException;
import com.gft_inditex.product_pricing_server.domain.exception.NegativeValueException;
import com.gft_inditex.product_pricing_server.domain.exception.NullValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ValueObjectValidationUtilTest {

    private static final String FIELD_NAME = "fieldName";

    @Test
    void givenNullObject_whenCheckNonNullArgument_thenThrowsNullValueException() {
        // Given null

        // When
        final Executable executable = () -> ValueObjectValidationUtil.checkNonNullArgument(null, FIELD_NAME);

        // Then
        Assertions.assertThrows(NullValueException.class, executable);
    }

    @Test
    void givenObjectWithInvalidFormat_whenCheckValidFormat_thenThrowsInvalidFormatValueException() {
        // Given
        final String onlyNumbersRegex = "^\\d+$";
        final String nonCompliantValue = "value";

        // When
        final Executable executable = () -> ValueObjectValidationUtil.checkValidFormat(nonCompliantValue, onlyNumbersRegex, FIELD_NAME);

        // Then
        Assertions.assertThrows(InvalidFormatValueException.class, executable);
    }

    @Test
    void givenEmptyValue_whenCheckIsNotEmpty_thenThrowsEmptyValueException() {
        // Given
        final String emptyValue = "";

        // When
        final Executable executable = () -> ValueObjectValidationUtil.checkIsNotEmpty(emptyValue, FIELD_NAME);

        // Then
        Assertions.assertThrows(EmptyValueException.class, executable);
    }

    @Test
    void givenNegativeValue_whenCheckIsNotNegative_thenThrowsNegativeValueException() {
        // Given
        final Integer negativeValue = -1;

        // When
        final Executable executable = () -> ValueObjectValidationUtil.checkIsNotNegative(negativeValue, FIELD_NAME);

        // Then
        Assertions.assertThrows(NegativeValueException.class, executable);
    }

}