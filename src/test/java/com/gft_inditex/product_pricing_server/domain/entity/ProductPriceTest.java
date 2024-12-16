package com.gft_inditex.product_pricing_server.domain.entity;

import com.gft_inditex.product_pricing_server.domain.valueobject.brand.BrandId;
import com.gft_inditex.product_pricing_server.domain.valueobject.brand.BrandIdMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.EndDate;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.EndDateMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.Price;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.PriceList;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.PriceListMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.PriceMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.ProductId;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.ProductIdMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.StartDate;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.StartDateMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductPriceTest {

    @Test
    void givenValidParameters_whenConstructorIsCalled_thenReturnsProductPrice() {
        // Given
        final BrandId brandId = BrandIdMock.validBrandId();
        final StartDate startDate = StartDateMock.validStartDate();
        final EndDate endDate = EndDateMock.validEndDate();
        final PriceList priceList = PriceListMock.validPriceListMock();
        final ProductId productId = ProductIdMock.validProductId();
        final Price price = PriceMock.validPrice();

        // When
        final ProductPrice productPrice = new ProductPrice(
                brandId,
                startDate,
                endDate,
                priceList,
                productId,
                price
        );

        // Then
        Assertions.assertNotNull(productPrice);
    }

    @Test
    void givenValidParameters_whenBuilderIsUsed_thenReturnsProductPrice() {
        // Given
        final BrandId brandId = BrandIdMock.validBrandId();
        final StartDate startDate = StartDateMock.validStartDate();
        final EndDate endDate = EndDateMock.validEndDate();
        final PriceList priceList = PriceListMock.validPriceListMock();
        final ProductId productId = ProductIdMock.validProductId();
        final Price price = PriceMock.validPrice();

        // When
        final ProductPrice productPrice = ProductPrice.builder()
                .brandId(brandId.value())
                .startDate(startDate.value().toString())
                .endDate(endDate.value().toString())
                .price(priceList.value())
                .productId(productId.value())
                .price(price.value())
                .build();

        // Then
        Assertions.assertNotNull(productPrice);
    }

}