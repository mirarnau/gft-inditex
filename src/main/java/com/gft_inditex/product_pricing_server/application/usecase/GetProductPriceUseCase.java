package com.gft_inditex.product_pricing_server.application.usecase;

import com.gft_inditex.product_pricing_server.application.mapper.ProductPriceMapper;
import com.gft_inditex.product_pricing_server.application.model.product.request.ProductPriceRequest;
import com.gft_inditex.product_pricing_server.application.model.product.response.ProductPriceResponse;
import com.gft_inditex.product_pricing_server.domain.entity.ProductPrice;
import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDto;
import com.gft_inditex.product_pricing_server.domain.service.ProductPriceGetter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class GetProductPriceUseCase {

    private final ProductPriceGetter productPriceGetter;

    public ProductPriceResponse execute(final ProductPriceRequest productPriceRequest) {
        log.debug("execute method called with ProductRateRequest: {}", productPriceRequest);
        final GetProductPriceDto getProductPriceDto = ProductPriceMapper.toGetProductPriceDto(productPriceRequest);
        final ProductPrice productPrice = productPriceGetter.execute(getProductPriceDto);
        return ProductPriceMapper.toProductPriceResponse(productPrice);
    }

}
