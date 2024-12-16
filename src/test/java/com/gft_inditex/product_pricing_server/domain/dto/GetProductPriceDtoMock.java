package com.gft_inditex.product_pricing_server.domain.dto;

import com.gft_inditex.product_pricing_server.domain.valueobject.RequestedDate;
import com.gft_inditex.product_pricing_server.domain.valueobject.RequestedDateMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.brand.BrandId;
import com.gft_inditex.product_pricing_server.domain.valueobject.brand.BrandIdMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.ProductId;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.ProductIdMock;

public class GetProductPriceDtoMock {

    private GetProductPriceDtoMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static GetProductPriceDto validGetProductPriceDto() {
        final RequestedDate requestedDate = RequestedDateMock.validRequestedDate();
        final ProductId productId = ProductIdMock.validProductId();
        final BrandId brandId = BrandIdMock.validBrandId();
        return new GetProductPriceDto(requestedDate, productId, brandId);
    }

}