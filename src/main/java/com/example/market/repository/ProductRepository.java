package com.example.market.repository;

import com.example.market.entity.Computer;
import com.example.market.entity.Product;
import com.example.market.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, BaseRepository {

    List<Product> findAllByProductType(ProductType productType);
}
