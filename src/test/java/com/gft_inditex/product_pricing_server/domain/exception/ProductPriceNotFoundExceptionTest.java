package com.gft_inditex.product_pricing_server.domain.exception;

import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDto;
import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDtoMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductPriceNotFoundExceptionTest {

    @Test
    void givenFieldName_whenConstructorIsCalled_thenReturnsProductPriceNotFoundException() {
        // Given
        final GetProductPriceDto getProductPriceDto = GetProductPriceDtoMock.validGetProductPriceDto();
        final String message = "Not found";
        final String detailedMessage = "No price was found for product with ID: %s for brand with ID: %s on date: %s";

        // When
        final ProductPriceNotFoundException exception = new ProductPriceNotFoundException(getProductPriceDto);

        // Then
        Assertions.assertNotNull(exception);
        Assertions.assertEquals(message, exception.getMessage());
        Assertions.assertEquals(
                detailedMessage.formatted(
                        getProductPriceDto.productId().value(),
                        getProductPriceDto.brandId().value(),
                        getProductPriceDto.requestedDate().value().toString()),
                exception.getDetailedMessage());
    }

}