package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import com.gft_inditex.product_pricing_server.domain.valueobject.DateMock;

import java.time.LocalDateTime;

public class EndDateJpaMock {

    private EndDateJpaMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static EndDateJpa validEndDateJpa() {
        return new EndDateJpa(LocalDateTime.parse(DateMock.VALID_DATE));
    }

}