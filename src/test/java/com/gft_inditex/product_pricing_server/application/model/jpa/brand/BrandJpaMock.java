package com.gft_inditex.product_pricing_server.application.model.jpa.brand;

public class BrandJpaMock {

    public static final Long ID = 1L;
    public static final String NAME = "brandName";

    private BrandJpaMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static BrandJpa validBrandJpa() {
        return new BrandJpa(ID, NAME);
    }

}