package com.gft_inditex.product_pricing_server.infraestructure.repository;

import com.gft_inditex.product_pricing_server.application.model.jpa.productprice.ProductPriceJpa;
import com.gft_inditex.product_pricing_server.application.model.jpa.productprice.ProductPriceJpaMock;
import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDto;
import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDtoMock;
import com.gft_inditex.product_pricing_server.domain.entity.ProductPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
class PriceRepositoryAdapterTest {

    @InjectMocks
    PriceRepositoryAdapter priceRepositoryAdapter;
    @Mock
    JpaPriceRepository jpaPriceRepository;

    @Test
    void givenGetProductPriceDtoForExistingEntry_whenGetProductPrice_thenReturnsProductPrice() {
        // Given
        final GetProductPriceDto getProductPriceDto = GetProductPriceDtoMock.validGetProductPriceDto();
        final ProductPriceJpa productPriceJpa = ProductPriceJpaMock.validProductPriceJpa();
        Mockito.when(jpaPriceRepository.getProductPrice(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(Optional.of(productPriceJpa));

        // When
        final Optional<ProductPrice> productPrice = priceRepositoryAdapter.getProductPrice(getProductPriceDto);

        // Then
        Assertions.assertTrue(productPrice.isPresent());
        Mockito.verify(jpaPriceRepository, Mockito.times(1)).getProductPrice(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    void givenGetProductPriceDtoForNonExistingEntry_whenGetProductPrice_thenReturnsEmptyOptional() {
        // Given
        final GetProductPriceDto getProductPriceDto = GetProductPriceDtoMock.validGetProductPriceDto();
        Mockito.when(jpaPriceRepository.getProductPrice(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(Optional.empty());

        // When
        final Optional<ProductPrice> productPrice = priceRepositoryAdapter.getProductPrice(getProductPriceDto);

        // Then
        Assertions.assertTrue(productPrice.isEmpty());
        Mockito.verify(jpaPriceRepository, Mockito.times(1)).getProductPrice(Mockito.any(), Mockito.any(), Mockito.any());
    }

}