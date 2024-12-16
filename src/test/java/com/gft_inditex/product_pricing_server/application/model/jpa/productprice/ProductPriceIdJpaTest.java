package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ProductPriceIdJpaTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsProductPriceIdJpa() {
        // Given
        final Long value = ProductPriceIdJpaMock.VALID_PRODUCT_PRICE_ID;

        // When
        final ProductPriceIdJpa productPriceIdJpa = new ProductPriceIdJpa(value);

        // Then
        Assertions.assertNotNull(productPriceIdJpa);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenAnyExceptionIsThrown() {
        // Given null

        // When
        final Executable executable = () -> new ProductPriceIdJpa(null);

        // Then
        Assertions.assertDoesNotThrow(executable);
    }

}