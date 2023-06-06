package com.example.market.repository;

import com.example.market.entity.Monitor;
import com.example.market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long>, BaseRepository {

    Optional<Monitor> findByProduct(Product product);

}
