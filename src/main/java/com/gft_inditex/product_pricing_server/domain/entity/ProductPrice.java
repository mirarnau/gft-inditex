package com.gft_inditex.product_pricing_server.domain.entity;

import com.gft_inditex.product_pricing_server.domain.valueobject.brand.BrandId;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.EndDate;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.Price;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.PriceList;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.ProductId;
import com.gft_inditex.product_pricing_server.domain.valueobject.productprice.StartDate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductPrice {

    private BrandId brandId;
    private StartDate startDate;
    private EndDate endDate;
    private PriceList priceList;
    private ProductId productId;
    private Price price;

    public long brandId() {
        return brandId.value();
    }

    public String startDate() {
        return startDate.value().toString();
    }

    public String endDate() {
        return endDate.value().toString();
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

    public static ProductPriceBuilder builder() {
        return new ProductPriceBuilder();
    }

    public static class ProductPriceBuilder {
        private long brandIdValue;
        private String startDateValue;
        private String endDateValue;
        private int priceListValue;
        private int productIdValue;
        private Number priceValue;

        public ProductPriceBuilder brandId(final long brandIdValue) {
            this.brandIdValue = brandIdValue;
            return this;
        }

        public ProductPriceBuilder startDate(final String startDateValue) {
            this.startDateValue = startDateValue;
            return this;
        }

        public ProductPriceBuilder endDate(final String endDateValue) {
            this.endDateValue = endDateValue;
            return this;
        }

        public ProductPriceBuilder priceList(final int priceListValue) {
            this.priceListValue = priceListValue;
            return this;
        }

        public ProductPriceBuilder productId(final int productIdValue) {
            this.productIdValue = productIdValue;
            return this;
        }

        public ProductPriceBuilder price(final Number priceValue) {
            this.priceValue = priceValue;
            return this;
        }

        public ProductPrice build() {
            final BrandId brandId = new BrandId(brandIdValue);
            final StartDate startDate = new StartDate(startDateValue);
            final EndDate endDate = new EndDate(endDateValue);
            final PriceList priceList = new PriceList(priceListValue);
            final ProductId productId = new ProductId(productIdValue);
            final Price price = new Price(priceValue);
            return new ProductPrice(
                    brandId,
                    startDate,
                    endDate,
                    priceList,
                    productId,
                    price
            );
        }
    }

}
