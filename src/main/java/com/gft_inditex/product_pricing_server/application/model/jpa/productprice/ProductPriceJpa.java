package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import com.gft_inditex.product_pricing_server.application.model.jpa.brand.BrandJpa;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "prices")
public class ProductPriceJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private BrandJpa brand;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "price_list")
    private Integer priceList;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "price")
    private BigDecimal price;

    public BrandJpa brand() {
        return brand;
    }

    public String startDate() {
        return startDate.toString();
    }

    public String endDate() {
        return endDate.toString();
    }

    public int priceList() {
        return priceList;
    }

    public int productId() {
        return productId;
    }

    public Number price() {
        return price;
    }

}
