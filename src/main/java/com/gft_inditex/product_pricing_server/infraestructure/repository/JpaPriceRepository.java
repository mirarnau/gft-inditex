package com.gft_inditex.product_pricing_server.infraestructure.repository;

import com.gft_inditex.product_pricing_server.application.model.jpa.productprice.ProductPriceJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface JpaPriceRepository extends JpaRepository<ProductPriceJpa, Long> {

    @Query("SELECT pp FROM ProductPriceJpa pp " +
            "WHERE pp.brand.id = ?1 " +
            "AND pp.productId = ?2 " +
            "AND ?3 BETWEEN pp.startDate AND pp.endDate " +
            "ORDER BY pp.priority DESC " +
            "LIMIT 1")
    Optional<ProductPriceJpa> getProductPrice(Long brandId, Integer productId, LocalDateTime requestedDate);

}
