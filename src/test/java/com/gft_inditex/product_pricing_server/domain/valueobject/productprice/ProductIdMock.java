package com.gft_inditex.product_pricing_server.domain.valueobject.productprice;

public class ProductIdMock {

    public static final Integer VALID_PRODUCT_ID = 35455;

    private ProductIdMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static ProductId validProductId() {
        return new ProductId(VALID_PRODUCT_ID);
    }

}