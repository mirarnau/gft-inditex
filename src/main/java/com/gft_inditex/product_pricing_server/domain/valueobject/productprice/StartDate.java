package com.gft_inditex.product_pricing_server.domain.valueobject.productprice;

import com.gft_inditex.product_pricing_server.domain.valueobject.Date;

public class StartDate extends Date {

    private static final String CLASS_NAME = StartDate.class.getSimpleName();

    public StartDate(final String value) {
        super(value, CLASS_NAME);
    }

}
