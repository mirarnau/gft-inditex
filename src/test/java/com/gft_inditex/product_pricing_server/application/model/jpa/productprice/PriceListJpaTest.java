package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class PriceListJpaTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsPriceListJpa() {
        // Given
        final Integer value = PriceListJpaMock.VALID_PRICE_LIST_VALUE;

        // When
        final PriceListJpa priceListJpa = new PriceListJpa(value);

        // Then
        Assertions.assertNotNull(priceListJpa);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenAnyExceptionIsThrown() {
        // Given null

        // When
        final Executable executable = () -> new PriceListJpa(null);

        // Then
        Assertions.assertDoesNotThrow(executable);
    }

}