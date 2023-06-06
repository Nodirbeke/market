package com.example.market.repository;

import com.example.market.entity.Computer;
import com.example.market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, BaseRepository {
}
