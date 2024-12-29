package com.gft_inditex.product_pricing_server.application.model.jpa.brand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BrandJpaTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsBrandJpa() {
        // Given
        final Long id = BrandJpaMock.ID;
        final String name = BrandJpaMock.NAME;

        // When
        final BrandJpa brandJpa = new BrandJpa(id, name);

        // Then
        Assertions.assertNotNull(brandJpa);
        Assertions.assertNotNull(brandJpa.getId());
        Assertions.assertNotNull(brandJpa.getName());
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenAnyExceptionIsThrown() {
        // Given null

        // When
        final Executable executable = () -> new BrandJpa(null, null);

        // Then
        Assertions.assertDoesNotThrow(executable);
    }

}