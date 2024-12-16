package com.gft_inditex.product_pricing_server.domain.valueobject.productprice;

import com.gft_inditex.product_pricing_server.domain.util.ValueObjectValidationUtil;
import com.gft_inditex.product_pricing_server.domain.valueobject.ValueObject;

public record ProductId(Integer value) implements ValueObject<Integer> {

    private static final String CLASS_NAME = ProductId.class.getSimpleName();

    public ProductId {
        validate(value);
    }

    private void validate(final Integer value) {
        ValueObjectValidationUtil.checkNonNullArgument(value, CLASS_NAME);
        ValueObjectValidationUtil.checkIsNotNegative(value, CLASS_NAME);
    }

}