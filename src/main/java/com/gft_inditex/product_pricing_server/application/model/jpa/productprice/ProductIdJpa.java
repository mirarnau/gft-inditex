package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class ProductIdJpa {

    @Column(name = "product_id")
    private Integer value;

    public Integer value() {
        return value;
    }

}