package com.gft_inditex.product_pricing_server.domain.valueobject.productprice;

public class PriceMock {

    public static final Number VALID_PRICE_VALUE = 35.50;

    private PriceMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static Price validPrice() {
        return new Price(VALID_PRICE_VALUE);
    }

}