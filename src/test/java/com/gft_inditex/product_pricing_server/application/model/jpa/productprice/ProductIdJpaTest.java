package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ProductIdJpaTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsProductIdJpa() {
        // Given
        final Integer value = ProductIdJpaMock.VALID_PRODUCT_ID;

        // When
        final ProductIdJpa productIdJpa = new ProductIdJpa(value);

        // Then
        Assertions.assertNotNull(productIdJpa);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenAnyExceptionIsThrown() {
        // Given null

        // When
        final Executable executable = () -> new ProductIdJpa(null);

        // Then
        Assertions.assertDoesNotThrow(executable);
    }

}