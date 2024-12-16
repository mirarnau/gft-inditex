package com.gft_inditex.product_pricing_server.domain.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmptyValueExceptionTest {

    @Test
    void givenFieldName_whenConstructorIsCalled_thenReturnsEmptyValueException() {
        // Given
        final String fieldName = "fieldName";
        final String message = "Invalid parameter";
        final String detailedMessage = "%s must not be empty";

        // When
        final EmptyValueException exception = new EmptyValueException(fieldName);

        // Then
        Assertions.assertNotNull(exception);
        Assertions.assertEquals(message, exception.getMessage());
        Assertions.assertEquals(detailedMessage.formatted(fieldName), exception.getDetailedMessage());
    }

}