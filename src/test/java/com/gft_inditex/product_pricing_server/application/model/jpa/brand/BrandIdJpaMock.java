package com.gft_inditex.product_pricing_server.application.model.jpa.brand;

public class BrandIdJpaMock {

    public static final Long VALID_BRAND_ID_JPA = 1L;

    private BrandIdJpaMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static BrandIdJpa validBrandIdJpa() {
        return new BrandIdJpa(VALID_BRAND_ID_JPA);
    }

}