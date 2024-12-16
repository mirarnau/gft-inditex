package com.gft_inditex.product_pricing_server.domain.exception;

import com.gft_inditex.product_pricing_server.domain.dto.GetProductPriceDto;
import lombok.Getter;

import java.io.Serial;

@Getter
public class ProductPriceNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Not found";
    private static final String DETAILED_MESSAGE = "No price was found for product with ID: %s for brand with ID: %s on date: %s";

    @Serial
    private static final long serialVersionUID = -4948393196499627119L;

    private final String message;
    private final String detailedMessage;

    public ProductPriceNotFoundException(final GetProductPriceDto getProductPriceDto) {
        super(MESSAGE);
        this.message = MESSAGE;
        this.detailedMessage = DETAILED_MESSAGE.formatted(
                getProductPriceDto.productId().value(),
                getProductPriceDto.brandId().value(),
                getProductPriceDto.requestedDate().value().toString());
    }

}
