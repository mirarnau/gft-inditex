package com.gft_inditex.product_pricing_server.application.model.product.request;

public record ProductPriceRequest(String date,
                                  Integer productId,
                                  Long brandId) {
}
