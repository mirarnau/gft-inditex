package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import com.gft_inditex.product_pricing_server.domain.valueobject.DateMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDateTime;

class EndDateJpaTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsEndDateJpa() {
        // Given
        final LocalDateTime value = LocalDateTime.parse(DateMock.VALID_DATE);

        // When
        final EndDateJpa endDateJpa = new EndDateJpa(value);

        // Then
        Assertions.assertNotNull(endDateJpa);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenAnyExceptionIsThrown() {
        // Given null

        // When
        final Executable executable = () -> new EndDateJpa(null);

        // Then
        Assertions.assertDoesNotThrow(executable);
    }

}