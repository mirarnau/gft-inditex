package com.gft_inditex.product_pricing_server.application.mapper;

import com.gft_inditex.product_pricing_server.application.model.jpa.productprice.ProductPriceJpa;
import com.gft_inditex.product_pricing_server.application.model.product.request.ProductPriceRequest;
import com.gft_inditex.product_pricing_server.application.model.product.response.ProductPriceResponse;
import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDto;
import com.gft_inditex.product_pricing_server.domain.entity.ProductPrice;
import com.gft_inditex.product_pricing_server.domain.valueobject.RequestedDate;
import com.gft_inditex.product_pricing_server.domain.valueobject.brand.BrandId;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.ProductId;

public class ProductPriceMapper {

    private ProductPriceMapper() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static GetProductPriceDto toGetProductPriceDto(final ProductPriceRequest productPriceRequest) {
        final RequestedDate requestedDate = new RequestedDate(productPriceRequest.date());
        final ProductId productId = new ProductId(productPriceRequest.productId());
        final BrandId brandId = new BrandId(productPriceRequest.brandId());
        return new GetProductPriceDto(requestedDate, productId, brandId);
    }

    public static ProductPrice toProductPrice(final ProductPriceJpa productPriceJpa) {
        return ProductPrice.builder()
                .brandId(productPriceJpa.getBrand().getId())
                .startDate(productPriceJpa.getStartDate().toString())
                .endDate(productPriceJpa.getEndDate().toString())
                .priceList(productPriceJpa.getPriceList())
                .productId(productPriceJpa.getProductId())
                .price(productPriceJpa.getPrice())
                .build();
    }

    public static ProductPriceResponse toProductPriceResponse(final ProductPrice productPrice) {
        final int productId = productPrice.productId();
        final long brandId = productPrice.brandId();
        final int rateId = productPrice.priceList();
        final String startDate = productPrice.startDate();
        final String endDate = productPrice.endDate();
        final Number price = productPrice.price();
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
