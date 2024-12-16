package com.gft_inditex.product_pricing_server.domain.valueobject;

public class RequestedDate extends Date {

    private static final String CLASS_NAME = RequestedDate.class.getSimpleName();

    public RequestedDate(final String value) {
        super(value, CLASS_NAME);
    }

}
