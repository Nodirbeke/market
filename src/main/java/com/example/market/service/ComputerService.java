package com.example.market.service;

import com.example.market.entity.Computer;
import com.example.market.entity.Product;
import com.example.market.exception.NotFoundException;
import com.example.market.mapper.GenericMapper;
import com.example.market.model.request.ComputerCreateDTO;
import com.example.market.repository.ComputerRepository;
import com.example.market.service.base.AbstractService;
import com.example.market.service.base.GenericCRUDService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService extends AbstractService<ComputerRepository>
        implements GenericCRUDService<ComputerCreateDTO, Computer, Long>,
        GenericMapper<Computer, ComputerCreateDTO> {

    private final ProductService productService;

    public ComputerService(ComputerRepository repository,
                           @Lazy ProductService productService) {
        super(repository);
        this.productService = productService;
    }


    @Override
    @Transactional
    public Computer create(ComputerCreateDTO createDTO) {
        Computer computer = toEntity(createDTO);
        return repository.save(computer);
    }

    @Override
    @Transactional
    public Computer get(Long key) {
        Optional<Computer> computerOptional = repository.findById(key);
        return computerOptional.orElseThrow(() -> new NotFoundException("COMPUTER_NOT_FOUND"));
    }

    @Override
    public List<Computer> list() {
        List<Computer> computers = repository.findAll();
        return computers;
    }

    @Override
    @Transactional
    public Computer update(Computer updatingEntity) {
        get(updatingEntity.getId());
        Computer updatedComputer = repository.save(updatingEntity);
        return updatedComputer;
    }

    @Override
    public Boolean delete(Long key) {
        repository.deleteById(key);
        return Boolean.TRUE;
    }

    public Computer getByProductId(Long id) {
        Product product = productService.get(id);
        return repository.findByProduct(product)
                .orElseThrow(() -> new NotFoundException("COMPUTER_NOT_FOUND"));
    }

    @Override
    public Computer toEntity(ComputerCreateDTO createDTO) {
        Product product = productService.toEntity(createDTO.getProductCreateDTO());
        return new Computer(product, createDTO.getComputerType());
    }
}
