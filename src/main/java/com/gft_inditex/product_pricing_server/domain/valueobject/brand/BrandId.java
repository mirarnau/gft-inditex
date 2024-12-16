package com.gft_inditex.product_pricing_server.domain.valueobject.brand;

import com.gft_inditex.product_pricing_server.domain.util.ValueObjectValidationUtil;
import com.gft_inditex.product_pricing_server.domain.valueobject.ValueObject;

public record BrandId(Long value) implements ValueObject<Long> {

    private static final String CLASS_NAME = BrandId.class.getSimpleName();

    public BrandId {
        ValueObjectValidationUtil.checkNonNullArgument(value, CLASS_NAME);
        ValueObjectValidationUtil.checkIsNotNegative(value, CLASS_NAME);
    }

}
