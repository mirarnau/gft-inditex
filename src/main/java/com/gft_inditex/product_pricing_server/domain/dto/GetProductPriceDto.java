package com.gft_inditex.product_pricing_server.domain.dto;

import com.gft_inditex.product_pricing_server.domain.valueobject.RequestedDate;
import com.gft_inditex.product_pricing_server.domain.valueobject.brand.BrandId;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.ProductId;

public record GetProductPriceDto(RequestedDate requestedDate,
                                 ProductId productId,
                                 BrandId brandId) {
}
