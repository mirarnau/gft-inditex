package com.gft_inditex.product_pricing_server.domain.entity;

import com.gft_inditex.product_pricing_server.domain.valueobject.DateMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.brand.BrandIdMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.PriceListMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.PriceMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.ProductIdMock;

public class ProductPriceMock {

    private ProductPriceMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static ProductPrice validProductPrice() {
        return ProductPrice.builder()
                .brandId(BrandIdMock.VALID_BRAND_ID)
                .startDate(DateMock.VALID_DATE)
                .endDate(DateMock.VALID_DATE)
                .priceList(PriceListMock.VALID_PRICE_LIST_VALUE)
                .productId(ProductIdMock.VALID_PRODUCT_ID)
                .price(PriceMock.VALID_PRICE_VALUE)
                .build();
    }

}