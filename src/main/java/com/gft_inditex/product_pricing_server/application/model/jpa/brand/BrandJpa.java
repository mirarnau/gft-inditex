package com.gft_inditex.product_pricing_server.application.model.jpa.brand;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "brand")
public class BrandJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BrandIdJpa id;

    public long id() {
        return id.value();
    }

}
