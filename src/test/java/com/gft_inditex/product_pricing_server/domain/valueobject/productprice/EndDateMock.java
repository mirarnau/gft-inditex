package com.gft_inditex.product_pricing_server.domain.valueobject.productprice;

import com.gft_inditex.product_pricing_server.domain.valueobject.DateMock;

public class EndDateMock {

    private EndDateMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static EndDate validEndDate() {
        return new EndDate(DateMock.VALID_DATE);
    }

}