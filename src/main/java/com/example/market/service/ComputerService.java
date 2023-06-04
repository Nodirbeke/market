package com.example.market.service;

import com.example.market.mapper.MyMapper;
import com.example.market.model.request.ComputerCreateDTO;
import com.example.market.entity.Computer;
import com.example.market.repository.ComputerRepository;
import com.example.market.service.base.AbstractService;
import com.example.market.service.base.GenericCRUDService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComputerService extends AbstractService<ComputerRepository>
        implements GenericCRUDService<ComputerCreateDTO, Computer, Long>,
        MyMapper<Computer, ComputerCreateDTO> {

    public ComputerService(ComputerRepository repository) {
        super(repository);
    }


    @Override
    public Computer create(ComputerCreateDTO createDTO) {
        Computer computer = toEntity(createDTO);
        Computer save = repository.save(computer);
        return save;
    }

    @Override
    @Transactional
    public Computer get(Long key) {
        Computer computer = repository.getReferenceById(key);
        return computer;
    }

    @Override
    public List<Computer> list() {
        List<Computer> computers = repository.findAll();
        return computers;
    }

    @Override
    public Computer update(Computer computer) {
        Computer updatedComputer = repository.save(computer);
        return updatedComputer;
    }

    @Override
    public Boolean delete(Long key) {
        repository.deleteById(key);
        return Boolean.TRUE;
    }

    @Override
    public Computer toEntity(ComputerCreateDTO createDTO) {
        return Computer.childBuilder()
                .cost(createDTO.getCost())
                .type(createDTO.getType())
                .count(createDTO.getCount())
                .producer(createDTO.getProducer())
                .serialNumber(createDTO.getSerialNumber())
                .build();
    }
}
