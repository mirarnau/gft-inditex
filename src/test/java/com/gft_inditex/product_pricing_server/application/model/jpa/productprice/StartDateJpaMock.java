package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import com.gft_inditex.product_pricing_server.domain.valueobject.DateMock;

import java.time.LocalDateTime;

public class StartDateJpaMock {


    private StartDateJpaMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static StartDateJpa validStartDateJpa() {
        return new StartDateJpa(LocalDateTime.parse(DateMock.VALID_DATE));
    }

}