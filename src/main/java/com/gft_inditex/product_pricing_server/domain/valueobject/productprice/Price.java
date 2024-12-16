package com.gft_inditex.product_pricing_server.domain.valueobject.productprice;

import com.gft_inditex.product_pricing_server.domain.util.ValueObjectValidationUtil;
import com.gft_inditex.product_pricing_server.domain.valueobject.ValueObject;

import java.math.BigDecimal;

public class Price implements ValueObject<BigDecimal> {

    private static final String CLASS_NAME = Price.class.getSimpleName();

    private final BigDecimal value;

    public Price(final Number value) {
        validate(value);
        this.value = new BigDecimal(value.toString());
    }

    @Override
    public BigDecimal value() {
        return value;
    }

    private void validate(final Number value) {
        ValueObjectValidationUtil.checkNonNullArgument(value, CLASS_NAME);
        ValueObjectValidationUtil.checkIsNotNegative(value, CLASS_NAME);
    }

}
