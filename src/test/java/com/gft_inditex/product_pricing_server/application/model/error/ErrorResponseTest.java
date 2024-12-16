package com.gft_inditex.product_pricing_server.application.model.error;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ErrorResponseTest {

    @Test
    void givenMessageAndDetailedMessage_whenConstructorIsCalled_thenReturnsErrorResponse() {
        // Given
        final String statusCode = String.valueOf(HttpStatus.ACCEPTED);
        final String message = ErrorResponseMock.MESSAGE;
        final String detailedMessage = ErrorResponseMock.DETAILED_MESSAGE;

        // When
        final ErrorResponse errorResponse = new ErrorResponse(statusCode, message, detailedMessage);

        // Then
        Assertions.assertNotNull(errorResponse);
    }

    @Test
    void givenMessageAndDetailedMessage_whenInvalidData_thenReturnsErrorResponseWithBadRequest() {
        // Given
        final String message = ErrorResponseMock.MESSAGE;
        final String detailedMessage = ErrorResponseMock.DETAILED_MESSAGE;

        // When
        final ErrorResponse errorResponse = ErrorResponse.invalidData(message, detailedMessage);

        // Then
        Assertions.assertNotNull(errorResponse);
        Assertions.assertEquals(String.valueOf(HttpStatus.BAD_REQUEST.value()), errorResponse.statusCode());
    }

    @Test
    void givenMessageAndDetailedMessage_whenNotFound_thenReturnsErrorResponseWithNotFound() {
        // Given
        final String message = ErrorResponseMock.MESSAGE;
        final String detailedMessage = ErrorResponseMock.DETAILED_MESSAGE;

        // When
        final ErrorResponse errorResponse = ErrorResponse.notFound(message, detailedMessage);

        // Then
        Assertions.assertNotNull(errorResponse);
        Assertions.assertEquals(String.valueOf(HttpStatus.NOT_FOUND.value()), errorResponse.statusCode());
    }

}