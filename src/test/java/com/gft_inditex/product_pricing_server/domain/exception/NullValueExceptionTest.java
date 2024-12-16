package com.gft_inditex.product_pricing_server.domain.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NullValueExceptionTest {

    @Test
    void givenFieldName_whenConstructorIsCalled_thenReturnsNullValueException() {
        // Given
        final String fieldName = "fieldName";
        final String message = "Invalid parameter";
        final String detailedMessage = "%s is null.";

        // When
        final NullValueException exception = new NullValueException(fieldName);

        // Then
        Assertions.assertNotNull(exception);
        Assertions.assertEquals(message, exception.getMessage());
        Assertions.assertEquals(detailedMessage.formatted(fieldName), exception.getDetailedMessage());
    }

}