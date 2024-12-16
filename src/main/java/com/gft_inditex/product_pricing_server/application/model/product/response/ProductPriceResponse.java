package com.gft_inditex.product_pricing_server.application.model.product.response;

public record ProductPriceResponse(int productId,
                                   long brandId,
                                   int rateId,
                                   String startDate,
                                   String endDate,
                                   Number price) {
}
