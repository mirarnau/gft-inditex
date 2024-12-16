package com.gft_inditex.product_pricing_server.application.model.jpa.brand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BrandNameJpaTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsBrandNameJpa() {
        // Given
        final String value = BrandNameJpaMock.VALID_BRAND_NAME_JPA_VALUE;

        // When
        final BrandNameJpa brandNameJpa = new BrandNameJpa(value);

        // Then
        Assertions.assertNotNull(brandNameJpa);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenAnyExceptionIsThrown() {
        // Given null

        // When
        final Executable executable = () -> new BrandNameJpa(null);

        // Then
        Assertions.assertDoesNotThrow(executable);
    }

}