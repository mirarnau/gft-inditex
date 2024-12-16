package com.gft_inditex.product_pricing_server.domain.valueobject.brand;

import com.gft_inditex.product_pricing_server.domain.exception.NegativeValueException;
import com.gft_inditex.product_pricing_server.domain.exception.NullValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BrandIdTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsBrandId() {
        // Given
        final Long value = BrandIdMock.VALID_BRAND_ID;

        // When
        final BrandId brandId = new BrandId(value);

        // Then
        Assertions.assertNotNull(brandId);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenThrowsNullValueException() {
        // Given null

        // When
        final Executable executable = () -> new BrandId(null);

        // Then
        Assertions.assertThrows(NullValueException.class, executable);
    }

    @Test
    void givenNegativeValue_whenConstructorIsCalled_thenThrowsNegativeValueException() {
        // Given
        final long negativeValue = -1;

        // When
        final Executable executable = () -> new BrandId(negativeValue);

        // Then
        Assertions.assertThrows(NegativeValueException.class, executable);
    }

}