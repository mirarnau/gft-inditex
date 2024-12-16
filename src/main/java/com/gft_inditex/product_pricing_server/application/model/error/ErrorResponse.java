package com.gft_inditex.product_pricing_server.application.model.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(String statusCode,
                            String message,
                            String detailedMessage) {

    public static ErrorResponse invalidData(final String message, final String detailedMessage) {
        final String badRequest = String.valueOf(HttpStatus.BAD_REQUEST.value());
        return ErrorResponse.builder()
                .statusCode(badRequest)
                .message(message)
                .detailedMessage(detailedMessage)
                .build();
    }

    public static ErrorResponse notFound(final String message, final String detailedMessage) {
        final String notFound = String.valueOf(HttpStatus.NOT_FOUND.value());
        return ErrorResponse.builder()
                .statusCode(notFound)
                .message(message)
                .detailedMessage(detailedMessage)
                .build();
    }

}
