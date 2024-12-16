package com.gft_inditex.product_pricing_server.application.usecase;

import com.gft_inditex.product_pricing_server.application.model.product.request.ProductPriceRequest;
import com.gft_inditex.product_pricing_server.application.model.product.request.ProductPriceRequestMock;
import com.gft_inditex.product_pricing_server.application.model.product.response.ProductPriceResponse;
import com.gft_inditex.product_pricing_server.domain.entity.ProductPrice;
import com.gft_inditex.product_pricing_server.domain.entity.ProductPriceMock;
import com.gft_inditex.product_pricing_server.domain.service.ProductPriceGetter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class GetProductPriceUseCaseTest {

    @InjectMocks
    GetProductPriceUseCase getProductPriceUseCase;
    @Mock
    ProductPriceGetter productPriceGetter;

    @Test
    void givenProductPriceRequest_whenExecute_thenReturnProductPriceResponse() {
        // Given
        final ProductPriceRequest productPriceRequest = ProductPriceRequestMock.validProductPriceRequest();
        final ProductPrice expectedProductPrice = ProductPriceMock.validProductPrice();
        Mockito.when(productPriceGetter.execute(Mockito.any())).thenReturn(expectedProductPrice);

        // When
        final ProductPriceResponse productPriceResponse = getProductPriceUseCase.execute(productPriceRequest);

        // Then
        Assertions.assertNotNull(productPriceResponse);
        Mockito.verify(productPriceGetter, Mockito.times(1)).execute(Mockito.any());
    }

}