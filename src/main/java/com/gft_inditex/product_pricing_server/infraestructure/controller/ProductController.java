package com.gft_inditex.product_pricing_server.infraestructure.controller;

import com.gft_inditex.product_pricing_server.application.model.product.request.ProductPriceRequest;
import com.gft_inditex.product_pricing_server.application.model.product.response.ProductPriceResponse;
import com.gft_inditex.product_pricing_server.application.usecase.GetProductPriceUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "inditex/products")
@Tag(name = "INDITEX Product Pricing API", description = "API to get the applicable price for a product in a given timestamp")
public class ProductController {

    private final GetProductPriceUseCase getProductPriceUseCase;

    @PostMapping(path = "/price")
    public ResponseEntity<ProductPriceResponse> getProductPrice(@RequestBody final ProductPriceRequest productPriceRequest) {
        log.info("getProductPrice method called with input data: {}", productPriceRequest);
        final ProductPriceResponse productPriceResponse = getProductPriceUseCase.execute(productPriceRequest);
        return ResponseEntity
                .ok()
                .body(productPriceResponse);
    }

}
