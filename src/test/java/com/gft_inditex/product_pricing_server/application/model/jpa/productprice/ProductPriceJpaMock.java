package com.gft_inditex.product_pricing_server.application.model.jpa.productprice;

import com.gft_inditex.product_pricing_server.application.model.jpa.brand.BrandJpa;
import com.gft_inditex.product_pricing_server.application.model.jpa.brand.BrandJpaMock;
import com.gft_inditex.product_pricing_server.domain.valueobject.DateMock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductPriceJpaMock {

    public static final Long ID = 1L;
    public static final BrandJpa BRAND_JPA = BrandJpaMock.validBrandJpa();
    public static final LocalDateTime START_DATE = LocalDateTime.parse(DateMock.VALID_DATE);
    public static final LocalDateTime END_DATE = LocalDateTime.parse(DateMock.VALID_DATE);
    public static final Integer PRICE_LIST = 1;
    public static final Integer PRODUCT_ID = 35455;
    public static final Integer PRIORITY = 0;
    public static final BigDecimal PRICE = BigDecimal.valueOf(35.50);

    private ProductPriceJpaMock() {
        // Prevents class instantiation and subsequent SonarQube issues
    }

    public static ProductPriceJpa validProductPriceJpa() {

        return new ProductPriceJpa(
                ID,
                BRAND_JPA,
                START_DATE,
                END_DATE,
                PRICE_LIST,
                PRODUCT_ID,
                PRIORITY,
                PRICE
        );
    }

}