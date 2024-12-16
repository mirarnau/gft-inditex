package com.gft_inditex.product_pricing_server.domain.valueobject.productprice;

import com.gft_inditex.product_pricing_server.domain.valueobject.Date;

public class EndDate extends Date {

    private static final String CLASS_NAME = EndDate.class.getSimpleName();

    public EndDate(final String value) {
        super(value, CLASS_NAME);
    }

}
