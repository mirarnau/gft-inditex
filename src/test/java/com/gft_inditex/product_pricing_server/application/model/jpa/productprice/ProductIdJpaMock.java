package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

public class ProductIdJpaMock {

    public static final Integer VALID_PRODUCT_ID = 35455;

    private ProductIdJpaMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static ProductIdJpa validProductIdJpa() {
        return new ProductIdJpa(VALID_PRODUCT_ID);
    }

}