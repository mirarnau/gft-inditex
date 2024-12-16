package com.gft_inditex.product_pricing_server.domain.valueobject;

public class RequestedDateMock {

    private RequestedDateMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static RequestedDate validRequestedDate() {
        return new RequestedDate(DateMock.VALID_DATE);
    }

}