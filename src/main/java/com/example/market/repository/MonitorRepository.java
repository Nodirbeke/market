package com.example.market.repository;

import com.example.market.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long>, BaseRepository {
}
