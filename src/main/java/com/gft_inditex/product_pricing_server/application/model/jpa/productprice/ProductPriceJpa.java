package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import com.gft_inditex.product_pricing_server.application.model.jpa.brand.BrandJpa;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "prices")
public class ProductPriceJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ProductPriceIdJpa id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private BrandJpa brand;
    private StartDateJpa startDate;
    private EndDateJpa endDate;
    private PriceListJpa priceList;
    private ProductIdJpa productId;
    private PriorityJpa priority;
    private PriceJpa price;

    public BrandJpa brand() {
        return brand;
    }

    public String startDate() {
        return startDate.value();
    }

    public String endDate() {
        return endDate.value();
    }

    public int priceList() {
        return priceList.value();
    }

    public int productId() {
        return productId.value();
    }

    public Number price() {
        return price.value();
    }

}
