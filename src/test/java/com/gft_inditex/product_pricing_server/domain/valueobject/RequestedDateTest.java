package com.gft_inditex.product_pricing_server.domain.valueobject;

import com.gft_inditex.product_pricing_server.domain.exception.EmptyValueException;
import com.gft_inditex.product_pricing_server.domain.exception.InvalidFormatValueException;
import com.gft_inditex.product_pricing_server.domain.exception.NullValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class RequestedDateTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsRequestedDate() {
        // Given
        final String value = DateMock.VALID_DATE;

        // When
        final RequestedDate date = new RequestedDate(value);

        // Then
        Assertions.assertNotNull(date);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenThrowsNullValueException() {
        // Given

        // When
        final Executable executable = () -> new RequestedDate(null);

        // Then
        Assertions.assertThrows(NullValueException.class, executable);
    }

    @Test
    void givenEmptyValue_whenConstructorIsCalled_thenThrowsEmptyValueException() {
        // Given
        final String emptyValue = "";

        // When
        final Executable executable = () -> new RequestedDate(emptyValue);

        // Then
        Assertions.assertThrows(EmptyValueException.class, executable);
    }

    @Test
    void givenValueWithInvalidFormat_whenConstructorIsCalled_thenThrowsInvalidFormatValueException() {
        // Given
        final String regexInvalidValue = "regexInvalidValue";

        // When
        final Executable executable = () -> new RequestedDate(regexInvalidValue);

        // Then
        Assertions.assertThrows(InvalidFormatValueException.class, executable);
    }

}