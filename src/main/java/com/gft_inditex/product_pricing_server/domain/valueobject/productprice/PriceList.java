package com.gft_inditex.product_pricing_server.domain.valueobject.productprice;

import com.gft_inditex.product_pricing_server.domain.util.ValueObjectValidationUtil;
import com.gft_inditex.product_pricing_server.domain.valueobject.ValueObject;

public record PriceList(Integer value) implements ValueObject<Integer> {

    private static final String CLASS_NAME = PriceList.class.getSimpleName();

    public PriceList {
        validate(value);
    }

    private void validate(final Integer value) {
        ValueObjectValidationUtil.checkNonNullArgument(value, CLASS_NAME);
        ValueObjectValidationUtil.checkIsNotNegative(value, CLASS_NAME);
    }

}
