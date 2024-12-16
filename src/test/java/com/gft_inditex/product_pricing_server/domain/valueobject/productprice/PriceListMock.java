package com.gft_inditex.product_pricing_server.domain.valueobject.productprice;

public class PriceListMock {

    public static final Integer VALID_PRICE_LIST_VALUE = 1;

    private PriceListMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static PriceList validPriceListMock() {
        return new PriceList(VALID_PRICE_LIST_VALUE);
    }

}