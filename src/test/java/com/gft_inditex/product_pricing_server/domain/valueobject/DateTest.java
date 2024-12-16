package com.gft_inditex.product_pricing_server.domain.valueobject;

import com.gft_inditex.product_pricing_server.domain.exception.EmptyValueException;
import com.gft_inditex.product_pricing_server.domain.exception.InvalidFormatValueException;
import com.gft_inditex.product_pricing_server.domain.exception.NullValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class DateTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsDate() {
        // Given
        final String value = DateMock.VALID_DATE;
        final String subClassName = "subClassName";

        // When
        final Date date = new Date(value, subClassName);

        // Then
        Assertions.assertNotNull(date);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenThrowsNullValueException() {
        // Given
        final String subClassName = "subClassName";

        // When
        final Executable executable = () -> new Date(null, subClassName);

        // Then
        Assertions.assertThrows(NullValueException.class, executable);
    }

    @Test
    void givenEmptyValue_whenConstructorIsCalled_thenThrowsEmptyValueException() {
        // Given
        final String subClassName = "subClassName";
        final String emptyValue = "";

        // When
        final Executable executable = () -> new Date(emptyValue, subClassName);

        // Then
        Assertions.assertThrows(EmptyValueException.class, executable);
    }

    @Test
    void givenValueWithInvalidFormat_whenConstructorIsCalled_thenThrowsInvalidFormatValueException() {
        // Given
        final String subClassName = "subClassName";
        final String regexInvalidValue = "regexInvalidValue";

        // When
        final Executable executable = () -> new Date(regexInvalidValue, subClassName);

        // Then
        Assertions.assertThrows(InvalidFormatValueException.class, executable);
    }

}