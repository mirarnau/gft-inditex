package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

class PriceJpaTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsPriceJpa() {
        // Given
        final BigDecimal value = PriceJpaMock.VALID_PRICE_VALUE;

        // When
        final PriceJpa priceJpa = new PriceJpa(value);

        // Then
        Assertions.assertNotNull(priceJpa);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenAnyExceptionIsThrown() {
        // Given null

        // When
        final Executable executable = () -> new PriceJpa(null);

        // Then
        Assertions.assertDoesNotThrow(executable);
    }

}