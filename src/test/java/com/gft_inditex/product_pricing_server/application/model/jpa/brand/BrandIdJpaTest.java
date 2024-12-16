package com.gft_inditex.product_pricing_server.application.model.jpa.brand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BrandIdJpaTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsBrandIdJpa() {
        // Given
        final Long value = BrandIdJpaMock.VALID_BRAND_ID_JPA;

        // When
        final BrandIdJpa brandIdJpa = new BrandIdJpa(value);

        // Then
        Assertions.assertNotNull(brandIdJpa);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenAnyExceptionIsThrown() {
        // Given null

        // When
        final Executable executable = () -> new BrandIdJpa(null);

        // Then
        Assertions.assertDoesNotThrow(executable);
    }

}