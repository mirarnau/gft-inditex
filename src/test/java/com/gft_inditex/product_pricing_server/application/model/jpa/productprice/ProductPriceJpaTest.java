package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import com.gft_inditex.product_pricing_server.application.model.jpa.brand.BrandJpa;
import com.gft_inditex.product_pricing_server.application.model.jpa.brand.BrandJpaMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.DateMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class ProductPriceJpaTest {

    @Test
    void givenValidValues_whenConstructorIsCalled_thenReturnsProductPriceJpa() {
        // Given
        final Long id = 1L;
        final BrandJpa brandJpa = BrandJpaMock.validBrandJpa();
        final LocalDateTime startDate = LocalDateTime.parse(DateMock.VALID_DATE);
        final LocalDateTime endDate = LocalDateTime.parse(DateMock.VALID_DATE);
        final Integer priceList = 1;
        final Integer productId = 35455;
        final Integer priority = 0;
        final BigDecimal price = BigDecimal.valueOf(35.50);

        // When
        final ProductPriceJpa productPriceJpa = new ProductPriceJpa(
                id,
                brandJpa,
                startDate,
                endDate,
                priceList,
                productId,
                priority,
                price
        );

        // Then
        Assertions.assertNotNull(productPriceJpa);
    }

}