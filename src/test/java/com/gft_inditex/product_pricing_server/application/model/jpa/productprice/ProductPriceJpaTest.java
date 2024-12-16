package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import com.gft_inditex.product_pricing_server.application.model.jpa.brand.BrandJpa;
import com.gft_inditex.product_pricing_server.application.model.jpa.brand.BrandJpaMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductPriceJpaTest {

    @Test
    void givenValidValues_whenConstructorIsCalled_thenReturnsProductPriceJpa() {
        // Given
        final ProductPriceIdJpa productPriceIdJpa = ProductPriceIdJpaMock.validProductPriceIdJpa();
        final BrandJpa brandJpa = BrandJpaMock.validBrandJpa();
        final StartDateJpa startDateJpa = StartDateJpaMock.validStartDateJpa();
        final EndDateJpa endDateJpa = EndDateJpaMock.validEndDateJpa();
        final PriceListJpa priceListJpa = PriceListJpaMock.validPriceListJpa();
        final ProductIdJpa productIdJpa = ProductIdJpaMock.validProductIdJpa();
        final PriorityJpa priorityJpa = PriorityJpaMock.validPriorityJpa();
        final PriceJpa priceJpa = PriceJpaMock.validPriceJpa();

        // When
        final ProductPriceJpa productPriceJpa = new ProductPriceJpa(
                productPriceIdJpa,
                brandJpa,
                startDateJpa,
                endDateJpa,
                priceListJpa,
                productIdJpa,
                priorityJpa,
                priceJpa
        );

        // Then
        Assertions.assertNotNull(productPriceJpa);
    }

}