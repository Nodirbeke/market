package com.example.market.repository;

import com.example.market.entity.HDD;
import com.example.market.service.HDDService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HDDRepository extends JpaRepository<HDD,Long> ,BaseRepository{
    void deleteById(Long key);

}
