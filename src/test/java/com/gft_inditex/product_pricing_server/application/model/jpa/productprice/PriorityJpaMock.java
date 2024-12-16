package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

public class PriorityJpaMock {

    public static final Integer VALID_PRIORITY_VALUE = 0;

    private PriorityJpaMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static PriorityJpa validPriorityJpa() {
        return new PriorityJpa(VALID_PRIORITY_VALUE);
    }

}