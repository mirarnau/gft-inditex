package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class PriceJpa {

    @Column(name = "price")
    private BigDecimal value;

    public BigDecimal value() {
        return value;
    }

}
