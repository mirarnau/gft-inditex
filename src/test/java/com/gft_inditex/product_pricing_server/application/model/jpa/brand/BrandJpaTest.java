package com.gft_inditex.product_pricing_server.application.model.jpa.brand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BrandJpaTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsBrandJpa() {
        // Given
        final BrandIdJpa value = BrandIdJpaMock.validBrandIdJpa();

        // When
        final BrandJpa brandJpa = new BrandJpa(value);

        // Then
        Assertions.assertNotNull(brandJpa);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenAnyExceptionIsThrown() {
        // Given null

        // When
        final Executable executable = () -> new BrandJpa(null);

        // Then
        Assertions.assertDoesNotThrow(executable);
    }

}