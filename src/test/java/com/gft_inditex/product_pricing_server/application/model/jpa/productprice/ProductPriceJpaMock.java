package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import com.gft_inditex.product_pricing_server.application.model.jpa.brand.BrandJpa;
import com.gft_inditex.product_pricing_server.application.model.jpa.brand.BrandJpaMock;

public class ProductPriceJpaMock {

    private ProductPriceJpaMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static ProductPriceJpa validProductPriceJpa() {
        final ProductPriceIdJpa productPriceIdJpa = ProductPriceIdJpaMock.validProductPriceIdJpa();
        final BrandJpa brandJpa = BrandJpaMock.validBrandJpa();
        final StartDateJpa startDateJpa = StartDateJpaMock.validStartDateJpa();
        final EndDateJpa endDateJpa = EndDateJpaMock.validEndDateJpa();
        final PriceListJpa priceListJpa = PriceListJpaMock.validPriceListJpa();
        final ProductIdJpa productIdJpa = ProductIdJpaMock.validProductIdJpa();
        final PriorityJpa priorityJpa = PriorityJpaMock.validPriorityJpa();
        final PriceJpa priceJpa = PriceJpaMock.validPriceJpa();
        return new ProductPriceJpa(
                productPriceIdJpa,
                brandJpa,
                startDateJpa,
                endDateJpa,
                priceListJpa,
                productIdJpa,
                priorityJpa,
                priceJpa
        );
    }

}