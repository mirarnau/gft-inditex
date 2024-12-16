package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import com.gft_inditex.product_pricing_server.domain.valueobject.DateMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDateTime;

class StartDateJpaTest {

    @Test
    void givenValidValue_whenConstructorIsCalled_thenReturnsStartDateJpa() {
        // Given
        final LocalDateTime value = LocalDateTime.parse(DateMock.VALID_DATE);

        // When
        final StartDateJpa startDateJpa = new StartDateJpa(value);

        // Then
        Assertions.assertNotNull(startDateJpa);
    }

    @Test
    void givenNullValue_whenConstructorIsCalled_thenAnyExceptionIsThrown() {
        // Given null

        // When
        final Executable executable = () -> new StartDateJpa(null);

        // Then
        Assertions.assertDoesNotThrow(executable);
    }

}