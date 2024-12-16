package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class StartDateJpa {

    @Column(name = "start_date")
    private LocalDateTime value;

    public String value() {
        return value.toString();
    }

}
