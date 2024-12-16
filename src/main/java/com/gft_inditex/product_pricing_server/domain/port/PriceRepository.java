package com.gft_inditex.product_pricing_server.domain.port;

import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDto;
import com.gft_inditex.product_pricing_server.domain.entity.ProductPrice;

import java.util.Optional;

public interface PriceRepository {

    Optional<ProductPrice> getProductPrice(GetProductPriceDto getProductPriceDto);

}
