package com.gft_inditex.product_pricing_server.domain.valueobject.brand;

public class BrandIdMock {

    public static final long VALID_BRAND_ID = 1;

    private BrandIdMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static BrandId validBrandId() {
        return new BrandId(VALID_BRAND_ID);
    }

}