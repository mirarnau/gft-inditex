package com.gft_inditex.product_pricing_server.domain.service;

import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDto;
import com.gft_inditex.product_pricing_server.domain.entity.ProductPrice;
import com.gft_inditex.product_pricing_server.domain.exception.ProductPriceNotFoundException;
import com.gft_inditex.product_pricing_server.domain.port.PriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductPriceGetter {

    private final PriceRepository priceRepository;

    public ProductPrice execute(final GetProductPriceDto getProductPriceDto) {
        log.trace("execute method called with date: [{}], for product with ID: [{}] for brand with ID: [{}]",
                getProductPriceDto.requestedDate().value(), getProductPriceDto.productId().value(), getProductPriceDto.brandId().value());
        return priceRepository.getProductPrice(getProductPriceDto)
                .orElseThrow(() -> new ProductPriceNotFoundException(getProductPriceDto));

    }


}
