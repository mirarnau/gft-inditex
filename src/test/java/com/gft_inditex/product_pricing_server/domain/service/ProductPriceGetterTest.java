package com.gft_inditex.product_pricing_server.domain.service;

import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDto;
import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDtoMock;
import com.gft_inditex.product_pricing_server.domain.entity.ProductPrice;
import com.gft_inditex.product_pricing_server.domain.entity.ProductPriceMock;
import com.gft_inditex.product_pricing_server.domain.exception.ProductPriceNotFoundException;
import com.gft_inditex.product_pricing_server.domain.port.PriceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
class ProductPriceGetterTest {

    @InjectMocks
    ProductPriceGetter productPriceGetter;
    @Mock
    PriceRepository priceRepository;

    @Test
    void givenGetProductPriceDtoForExistingEntry_whenExecute_thenCallsPriceRepositoryAndReturnsProductPrice() {
        // Given
        final GetProductPriceDto getProductPriceDto = GetProductPriceDtoMock.validGetProductPriceDto();
        final ProductPrice expectedProductPrice = ProductPriceMock.validProductPrice();
        Mockito.when(priceRepository.getProductPrice(Mockito.any())).thenReturn(Optional.of(expectedProductPrice));

        // When
        final ProductPrice productPrice = productPriceGetter.execute(getProductPriceDto);

        // Then
        Assertions.assertNotNull(productPrice);
        Mockito.verify(priceRepository, Mockito.times(1)).getProductPrice(Mockito.any());
    }

    @Test
    void givenGetProductPriceDtoForNonExistingEntry_whenExecute_thenThrowsProductPriceNotFoundException() {
        // Given
        final GetProductPriceDto getProductPriceDto = GetProductPriceDtoMock.validGetProductPriceDto();
        Mockito.when(priceRepository.getProductPrice(Mockito.any())).thenReturn(Optional.empty());

        // When
        final Executable executable = () -> productPriceGetter.execute(getProductPriceDto);

        // Then
        Assertions.assertThrows(ProductPriceNotFoundException.class, executable);
    }

}