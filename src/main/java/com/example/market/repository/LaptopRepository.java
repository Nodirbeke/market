package com.example.market.repository;

import com.example.market.entity.Laptop;
import com.example.market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>, BaseRepository {
    Optional<Laptop> findByProduct(Product product);
}
