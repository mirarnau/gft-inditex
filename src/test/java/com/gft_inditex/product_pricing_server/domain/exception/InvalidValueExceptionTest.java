package com.gft_inditex.product_pricing_server.domain.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InvalidValueExceptionTest {

    @Test
    void givenFieldName_whenConstructorIsCalled_thenReturnsInvalidValueException() {
        // Given
        final String message = "Invalid parameter";
        final String detailedMessage = "detailedMessgae";

        // When
        final InvalidValueException exception = new InvalidValueException(detailedMessage);

        // Then
        Assertions.assertNotNull(exception);
        Assertions.assertEquals(message, exception.getMessage());
        Assertions.assertEquals(detailedMessage, exception.getDetailedMessage());
    }

}