package com.gft_inditex.product_pricing_server.application.model.product.request;

import com.gft_inditex.product_pricing_server.domain.valueobject.DateMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.brand.BrandIdMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.ProductIdMock;

public class ProductPriceRequestMock {

    private ProductPriceRequestMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static ProductPriceRequest validProductPriceRequest() {
        final String date = DateMock.VALID_DATE;
        final int productId = ProductIdMock.VALID_PRODUCT_ID;
        final long brandId = BrandIdMock.VALID_BRAND_ID;
        return new ProductPriceRequest(date, productId, brandId);
    }

}