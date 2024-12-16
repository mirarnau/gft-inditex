package com.gft_inditex.product_pricing_server.infraestructure.controller;

import com.gft_inditex.product_pricing_server.application.model.error.ErrorResponse;
import com.gft_inditex.product_pricing_server.domain.exception.EmptyValueException;
import com.gft_inditex.product_pricing_server.domain.exception.InvalidFormatValueException;
import com.gft_inditex.product_pricing_server.domain.exception.InvalidValueException;
import com.gft_inditex.product_pricing_server.domain.exception.NegativeValueException;
import com.gft_inditex.product_pricing_server.domain.exception.NullValueException;
import com.gft_inditex.product_pricing_server.domain.exception.ProductPriceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(assignableTypes = {ProductController.class})
public class ProductControllerAdvice {

    @ExceptionHandler({
            NullValueException.class,
            InvalidFormatValueException.class,
            NegativeValueException.class,
            EmptyValueException.class})
    public ResponseEntity<ErrorResponse> handleInvalidValueException(final InvalidValueException exception) {
        log.error(exception.getMessage(), exception);
        final ErrorResponse errorResponse = ErrorResponse.invalidData(exception.getMessage(), exception.getDetailedMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler({ProductPriceNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleProductPriceNotFoundException(final ProductPriceNotFoundException exception) {
        log.error(exception.getMessage(), exception);
        final ErrorResponse errorResponse = ErrorResponse.notFound(exception.getMessage(), exception.getDetailedMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

}
