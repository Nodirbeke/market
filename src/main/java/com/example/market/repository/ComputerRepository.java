package com.example.market.repository;

import com.example.market.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long>, BaseRepository {

    @Override
    Computer save(Computer computer);


    @Override
    List<Computer> findAll();

}
