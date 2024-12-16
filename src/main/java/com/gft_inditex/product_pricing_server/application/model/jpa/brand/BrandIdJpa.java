package com.gft_inditex.product_pricing_server.application.model.jpa.brand;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class BrandIdJpa {

    @Column(name = "id")
    private Long value;

    public Long value() {
        return value;
    }

}
