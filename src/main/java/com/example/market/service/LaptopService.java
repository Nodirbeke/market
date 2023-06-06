package com.example.market.service;

import com.example.market.entity.Laptop;
import com.example.market.entity.Product;
import com.example.market.exception.NotFoundException;
import com.example.market.mapper.GenericMapper;
import com.example.market.model.request.LaptopCreateDTO;
import com.example.market.repository.LaptopRepository;
import com.example.market.service.base.AbstractService;
import com.example.market.service.base.GenericCRUDService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService extends AbstractService<LaptopRepository>
        implements GenericCRUDService<LaptopCreateDTO, Laptop, Long>,
        GenericMapper<Laptop, LaptopCreateDTO> {

    private final ProductService productService;

    public LaptopService(LaptopRepository repository,
                         @Lazy ProductService productService) {
        super(repository);
        this.productService = productService;
    }

    @Override
    @Transactional
    public Laptop create(LaptopCreateDTO createDTO) {
        Laptop laptop = toEntity(createDTO);
        return repository.save(laptop);
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
    @Transactional
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

    public Laptop getByProductId(Long id) {
        Product product = productService.get(id);
        return repository.findByProduct(product)
                .orElseThrow(() -> new NotFoundException("LAPTOP_NOT_FOUND"));
    }

    @Override
    public Laptop toEntity(LaptopCreateDTO createDTO) {
        Product product = productService.toEntity(createDTO.getProductCreateDTO());
        return new Laptop(product, createDTO.getLaptopSize());
    }
}
