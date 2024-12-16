package com.gft_inditex.product_pricing_server.infraestructure.controller;

import com.gft_inditex.product_pricing_server.application.model.error.ErrorResponse;
import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDto;
import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDtoMock;
import com.gft_inditex.product_pricing_server.domain.exception.InvalidValueException;
import com.gft_inditex.product_pricing_server.domain.exception.ProductPriceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ProductControllerAdviceTest {

    private final ProductControllerAdvice pricesControllerAdvice = new ProductControllerAdvice();

    @Test
    void givenInvalidValueException_whenHandleInvalidValueException_thenReturnsBadRequestErrorResponse() {
        // Given
        final String message = "Invalid parameter";
        final String detailedMessage = "detailedMessage";
        final InvalidValueException invalidValueException = new InvalidValueException(detailedMessage);

        // When
        final ResponseEntity<ErrorResponse> response = pricesControllerAdvice.handleInvalidValueException(invalidValueException);

        // Then
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assertions.assertEquals(message, response.getBody().message());
        Assertions.assertEquals(detailedMessage, response.getBody().detailedMessage());
    }

    @Test
    void givenProductPriceNotFoundException_whenHandleInvalidValueException_thenReturnsNotFoundErrorResponse() {
        // Given
        final GetProductPriceDto getProductPriceDto = GetProductPriceDtoMock.validGetProductPriceDto();
        final String message = "Not found";
        final String detailedMessage = "No price was found for product with ID: %s for brand with ID: %s on date: %s";
        final ProductPriceNotFoundException productPriceNotFoundException = new ProductPriceNotFoundException(getProductPriceDto);

        // When
        final ResponseEntity<ErrorResponse> response = pricesControllerAdvice.handleProductPriceNotFoundException(productPriceNotFoundException);

        // Then
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertEquals(message, response.getBody().message());
        Assertions.assertEquals(
                detailedMessage.formatted(
                        getProductPriceDto.productId().value(),
                        getProductPriceDto.brandId().value(),
                        getProductPriceDto.requestedDate().value().toString()
                ),
                response.getBody().detailedMessage());
    }

}