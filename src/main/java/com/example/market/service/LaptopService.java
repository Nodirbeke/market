package com.example.market.service;

import com.example.market.entity.Laptop;
import com.example.market.exception.NotFoundException;
import com.example.market.mapper.GenericMapper;
import com.example.market.model.request.LaptopCreateDTO;
import com.example.market.repository.LaptopRepository;
import com.example.market.service.base.AbstractService;
import com.example.market.service.base.GenericCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService extends AbstractService<LaptopRepository>
        implements GenericCRUDService<LaptopCreateDTO, Laptop, Long>,
        GenericMapper<Laptop, LaptopCreateDTO> {

    public LaptopService(LaptopRepository repository) {
        super(repository);
    }

    @Override
    public Laptop create(LaptopCreateDTO createDTO) {
        Laptop laptop = toEntity(createDTO);
        Laptop newLaptop = repository.save(laptop);
        return newLaptop;
    }

    @Override
    public Laptop get(Long key) {
        Optional<Laptop> laptopOptional = repository.findById(key);
        return laptopOptional.orElseThrow(() -> new NotFoundException("LAPTOP_NOT_FOUND"));
    }

    @Override
    public List<Laptop> list() {
        return repository.findAll();
    }

    @Override
    public Laptop update(Laptop updatingEntity) {
        get(updatingEntity.getId());
        Laptop updatedEntity = repository.save(updatingEntity);
        return updatedEntity;
    }

    @Override
    public Boolean delete(Long key) {
        repository.deleteById(key);
        return Boolean.TRUE;
    }

    @Override
    public Laptop toEntity(LaptopCreateDTO createDTO) {
        return Laptop.childBuilder()
                .cost(createDTO.getCost())
                .count(createDTO.getCount())
                .producer(createDTO.getProducer())
                .laptopSize(createDTO.getLaptopSize())
                .serialNumber(createDTO.getSerialNumber())
                .build();
    }
}
