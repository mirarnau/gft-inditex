package com.gft_inditex.product_pricing_server.infraestructure.controller;

import com.gft_inditex.product_pricing_server.application.model.product.request.ProductPriceRequest;
import com.gft_inditex.product_pricing_server.application.model.product.request.ProductPriceRequestMock;
import com.gft_inditex.product_pricing_server.application.model.product.response.ProductPriceResponse;
import com.gft_inditex.product_pricing_server.application.model.product.response.ProductPriceResponseMock;
import com.gft_inditex.product_pricing_server.application.usecase.GetProductPriceUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ProductControllerTest {

    @InjectMocks
    ProductController productController;
    @Mock
    GetProductPriceUseCase getProductPriceUseCase;

    @Test
    void givenProductPriceRequest_whenGetProductPrice_thenCallsGetProductPriceUseCaseAndReturnsProductPriceResponse() {
        // Given
        final ProductPriceRequest productPriceRequest = ProductPriceRequestMock.validProductPriceRequest();
        final ProductPriceResponse expectedProductPriceResponse = ProductPriceResponseMock.validProductPriceResponse();
        Mockito.when(getProductPriceUseCase.execute(Mockito.any())).thenReturn(expectedProductPriceResponse);

        // When
        final ResponseEntity<ProductPriceResponse> response = productController.getProductPrice(productPriceRequest);

        // Then
        Assertions.assertNotNull(response);
        Assertions.assertEquals(expectedProductPriceResponse, response.getBody());
        Mockito.verify(getProductPriceUseCase, Mockito.times(1)).execute(Mockito.any());
    }

}