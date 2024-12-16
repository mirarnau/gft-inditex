package com.gft_inditex.product_pricing_server.infraestructure.repository;

import com.gft_inditex.product_pricing_server.application.mapper.ProductPriceMapper;
import com.gft_inditex.product_pricing_server.application.model.jpa.productprice.ProductPriceJpa;
import com.gft_inditex.product_pricing_server.domain.entity.ProductPrice;
import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDto;
import com.gft_inditex.product_pricing_server.domain.port.PriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PriceRepositoryAdapter implements PriceRepository {

    private final JpaPriceRepository jpaPriceRepository;

    @Override
    public Optional<ProductPrice> getProductPrice(final GetProductPriceDto getProductPriceDto) {
        final long brandId = getProductPriceDto.brandId().value();
        final int productId = getProductPriceDto.productId().value();
        final LocalDateTime requestedDate = getProductPriceDto.requestedDate().value();
        log.trace("Get Product Price method called with date: [{}], for product with ID: [{}] for brand with ID: [{}]",
                requestedDate, productId, brandId);
        final Optional<ProductPriceJpa> productPriceJpa = jpaPriceRepository.getProductPrice(brandId, productId, requestedDate);
        return productPriceJpa.map(ProductPriceMapper::toProductPrice);
    }

}
