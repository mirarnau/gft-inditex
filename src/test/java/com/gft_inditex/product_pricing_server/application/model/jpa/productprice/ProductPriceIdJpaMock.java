package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

public class ProductPriceIdJpaMock {

    public static final Long VALID_PRODUCT_PRICE_ID = 1L;

    private ProductPriceIdJpaMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static ProductPriceIdJpa validProductPriceIdJpa() {
        return new ProductPriceIdJpa(VALID_PRODUCT_PRICE_ID);
    }

}