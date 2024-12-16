package com.gft_inditex.product_pricing_server.application.model.product.response;

import com.gft_inditex.product_pricing_server.domain.valueobject.DateMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.brand.BrandIdMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.PriceListMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.PriceMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.ProductIdMock;

public class ProductPriceResponseMock {

    private ProductPriceResponseMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static ProductPriceResponse validProductPriceResponse() {
        final int productId = ProductIdMock.VALID_PRODUCT_ID;
        final long brandId = BrandIdMock.VALID_BRAND_ID;
        final int rateId = PriceListMock.VALID_PRICE_LIST_VALUE;
        final String startDate = DateMock.VALID_DATE;
        final String endDate = DateMock.VALID_DATE;
        final Number price = PriceMock.VALID_PRICE_VALUE;
        return new ProductPriceResponse(
                productId,
                brandId,
                rateId,
                startDate,
                endDate,
                price
        );
    }

}