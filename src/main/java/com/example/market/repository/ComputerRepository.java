package com.example.market.repository;

import com.example.market.entity.Computer;
import com.example.market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long>, BaseRepository {
    Optional<Computer> findByProduct(Product product);
}
