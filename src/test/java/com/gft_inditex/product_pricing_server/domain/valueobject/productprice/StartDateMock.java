package com.gft_inditex.product_pricing_server.domain.valueobject.productprice;

import com.gft_inditex.product_pricing_server.domain.valueobject.DateMock;

public class StartDateMock {

    private StartDateMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static StartDate validStartDate() {
        return new StartDate(DateMock.VALID_DATE);
    }

}