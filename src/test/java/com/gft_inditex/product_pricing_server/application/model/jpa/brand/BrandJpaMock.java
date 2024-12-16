package com.gft_inditex.product_pricing_server.application.model.jpa.brand;

public class BrandJpaMock {

    private BrandJpaMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static BrandJpa validBrandJpa() {
        final BrandIdJpa brandIdJpa = BrandIdJpaMock.validBrandIdJpa();
        return new BrandJpa(brandIdJpa);
    }

}