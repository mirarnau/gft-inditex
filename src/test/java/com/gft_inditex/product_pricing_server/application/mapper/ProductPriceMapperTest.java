package com.gft_inditex.product_pricing_server.application.mapper;

import com.gft_inditex.product_pricing_server.application.model.jpa.productprice.ProductPriceJpa;
import com.gft_inditex.product_pricing_server.application.model.jpa.productprice.ProductPriceJpaMock;
import com.gft_inditex.product_pricing_server.application.model.product.request.ProductPriceRequest;
import com.gft_inditex.product_pricing_server.application.model.product.request.ProductPriceRequestMock;
import com.gft_inditex.product_pricing_server.application.model.product.response.ProductPriceResponse;
import com.gft_inditex.product_pricing_server.application.model.product.response.ProductPriceResponseMock;
import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDto;
import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDtoMock;
import com.gft_inditex.product_pricing_server.domain.entity.ProductPrice;
import com.gft_inditex.product_pricing_server.domain.entity.ProductPriceMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductPriceMapperTest {

    @Test
    void givenProductPriceRequest_whenToGetProductPriceDto_thenReturnsGetProductPriceDto() {
        // Given
        final ProductPriceRequest productPriceRequest = ProductPriceRequestMock.validProductPriceRequest();
        final GetProductPriceDto expectedGetProductPriceDto = GetProductPriceDtoMock.validGetProductPriceDto();

        // When
        final GetProductPriceDto getProductPriceDto = ProductPriceMapper.toGetProductPriceDto(productPriceRequest);

        // Then
        Assertions.assertNotNull(getProductPriceDto);
        Assertions.assertEquals(expectedGetProductPriceDto.requestedDate().value(), getProductPriceDto.requestedDate().value());
        Assertions.assertEquals(expectedGetProductPriceDto.productId().value(), getProductPriceDto.productId().value());
        Assertions.assertEquals(expectedGetProductPriceDto.brandId().value(), getProductPriceDto.brandId().value());
    }

    @Test
    void givenProductPriceJpa_whenToProductPrice_thenReturnsProductPrice() {
        // Given
        final ProductPriceJpa productPriceJpa = ProductPriceJpaMock.validProductPriceJpa();
        final ProductPrice expectedProductPrice = ProductPriceMock.validProductPrice();

        // When
        final ProductPrice productPrice = ProductPriceMapper.toProductPrice(productPriceJpa);

        // Then
        Assertions.assertNotNull(productPrice);
        Assertions.assertEquals(expectedProductPrice.brandId(), productPrice.brandId());
        Assertions.assertEquals(expectedProductPrice.startDate(), productPrice.startDate());
        Assertions.assertEquals(expectedProductPrice.endDate(), productPrice.endDate());
        Assertions.assertEquals(expectedProductPrice.priceList(), productPrice.priceList());
        Assertions.assertEquals(expectedProductPrice.productId(), productPrice.productId());
        Assertions.assertEquals(expectedProductPrice.price(), productPrice.price());
    }

    @Test
    void givenProductPrice_whenToProductPriceResponse_thenReturnsProductPriceResponse() {
        // Given
        final ProductPrice productPrice = ProductPriceMock.validProductPrice();
        final ProductPriceResponse expectedProductPriceResponse = ProductPriceResponseMock.validProductPriceResponse();

        // When
        final ProductPriceResponse productPriceResponse = ProductPriceMapper.toProductPriceResponse(productPrice);

        // Then
        Assertions.assertNotNull(productPriceResponse);
        Assertions.assertEquals(expectedProductPriceResponse.productId(), productPriceResponse.productId());
        Assertions.assertEquals(expectedProductPriceResponse.brandId(), productPriceResponse.brandId());
        Assertions.assertEquals(expectedProductPriceResponse.rateId(), productPriceResponse.rateId());
        Assertions.assertEquals(expectedProductPriceResponse.startDate(), productPriceResponse.startDate());
        Assertions.assertEquals(expectedProductPriceResponse.endDate(), productPriceResponse.endDate());
        Assertions.assertEquals(expectedProductPriceResponse.price().toString(), productPriceResponse.price().toString());
    }

}