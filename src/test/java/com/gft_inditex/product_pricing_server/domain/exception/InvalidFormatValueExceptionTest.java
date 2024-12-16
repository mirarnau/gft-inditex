package com.gft_inditex.product_pricing_server.domain.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InvalidFormatValueExceptionTest {

    @Test
    void givenFieldName_whenConstructorIsCalled_thenReturnsInvalidFormatValueException() {
        // Given
        final String fieldName = "fieldName";
        final String value = "value";
        final String regex = "regex";
        final String message = "Invalid parameter";
        final String detailedMessage = "%s format is invalid. %s does not comply with %s regex.";

        // When
        final InvalidFormatValueException exception = new InvalidFormatValueException(fieldName, value, regex);

        // Then
        Assertions.assertNotNull(exception);
        Assertions.assertEquals(message, exception.getMessage());
        Assertions.assertEquals(detailedMessage.formatted(fieldName, value, regex), exception.getDetailedMessage());
    }

}