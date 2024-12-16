package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import java.math.BigDecimal;

public class PriceJpaMock {

    public static final BigDecimal VALID_PRICE_VALUE = BigDecimal.valueOf(35.50);

    private PriceJpaMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static PriceJpa validPriceJpa() {
        return new PriceJpa(VALID_PRICE_VALUE);
    }


}