package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

public class PriceListJpaMock {

    public static final Integer VALID_PRICE_LIST_VALUE = 1;

    private PriceListJpaMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static PriceListJpa validPriceListJpa() {
        return new PriceListJpa(VALID_PRICE_LIST_VALUE);
    }

}