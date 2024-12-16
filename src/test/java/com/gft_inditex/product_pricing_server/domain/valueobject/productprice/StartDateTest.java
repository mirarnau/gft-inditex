package com.gft_inditex.product_pricing_server.domain.valueobject.productprice;

import com.gft_inditex.product_pricing_server.domain.exception.EmptyValueException;
import com.gft_inditex.product_pricing_server.domain.exception.InvalidFormatValueException;
import com.gft_inditex.product_pricing_server.domain.exception.NullValueException;
import com.gft_inditex.product_pricing_server.domain.valueobject.DateMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class StartDateTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsDate() {
        // Given
        final String value = DateMock.VALID_DATE;

        // When
        final StartDate date = new StartDate(value);

        // Then
        Assertions.assertNotNull(date);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenThrowsNullValueException() {
        // Given

        // When
        final Executable executable = () -> new StartDate(null);

        // Then
        Assertions.assertThrows(NullValueException.class, executable);
    }

    @Test
    void givenEmptyValue_whenConstructorIsCalled_thenThrowsEmptyValueException() {
        // Given
        final String emptyValue = "";

        // When
        final Executable executable = () -> new StartDate(emptyValue);

        // Then
        Assertions.assertThrows(EmptyValueException.class, executable);
    }

    @Test
    void givenValueWithInvalidFormat_whenConstructorIsCalled_thenThrowsInvalidFormatValueException() {
        // Given
        final String regexInvalidValue = "regexInvalidValue";

        // When
        final Executable executable = () -> new StartDate(regexInvalidValue);

        // Then
        Assertions.assertThrows(InvalidFormatValueException.class, executable);
    }

}