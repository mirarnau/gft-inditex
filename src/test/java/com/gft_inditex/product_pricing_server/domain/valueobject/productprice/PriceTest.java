package com.gft_inditex.product_pricing_server.domain.valueobject.productprice;

import com.gft_inditex.product_pricing_server.domain.exception.NegativeValueException;
import com.gft_inditex.product_pricing_server.domain.exception.NullValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

class PriceTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsPrice() {
        // Given
        final BigDecimal value = BigDecimal.valueOf(PriceMock.VALID_PRICE_VALUE.doubleValue());

        // When
        final Price price = new Price(value);

        // Then
        Assertions.assertNotNull(price);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenThrowsNullValueException() {
        // Given null

        // When
        final Executable executable = () -> new Price(null);

        // Then
        Assertions.assertThrows(NullValueException.class, executable);
    }

    @Test
    void givenNegativeValue_whenConstructorIsCalled_thenThrowsNegativeValueException() {
        // Given
        final long negativeValue = -1;

        // When
        final Executable executable = () -> new Price(negativeValue);

        // Then
        Assertions.assertThrows(NegativeValueException.class, executable);
    }

}