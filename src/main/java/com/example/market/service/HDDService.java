package com.example.market.service;

import com.example.market.entity.HDD;
import com.example.market.entity.Product;
import com.example.market.enums.ProductType;
import com.example.market.exception.NotFoundException;
import com.example.market.mapper.GenericMapper;
import com.example.market.model.request.HDDCreateDTO;
import com.example.market.repository.HDDRepository;
import com.example.market.service.base.AbstractService;
import com.example.market.service.base.GenericCRUDService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HDDService extends AbstractService<HDDRepository>
        implements GenericCRUDService<HDDCreateDTO, HDD, Long>,
        GenericMapper<HDD, HDDCreateDTO> {

    private final ProductService productService;

    public HDDService(HDDRepository repository,
                      @Lazy ProductService productService) {
        super(repository);
        this.productService = productService;
    }

    @Override
    @Transactional
    public HDD create(HDDCreateDTO createDTO) {
        HDD newHDD = toEntity(createDTO);
        return repository.save(newHDD);
    }

    @Override
    public HDD get(Long key) {
        Optional<HDD> HDDOptional = repository.findById(key);
        return HDDOptional.orElseThrow(() -> new NotFoundException("HDD_NOT_FOUND"));
    }

    @Override
    public List<HDD> list() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public HDD update(HDD updatingEntity) {
        get(updatingEntity.getId());
        HDD updatedEntity = repository.save(updatingEntity);
        return updatedEntity;
    }

    @Override
    public Boolean delete(Long key) {
        repository.deleteById(key);
        return Boolean.TRUE;
    }

    public HDD getByProductId(Long id) {
        Product product = productService.get(id);
        return repository.findByProduct(product)
                .orElseThrow(() -> new NotFoundException("HDD_NOT_FOUND"));
    }

    @Override
    public HDD toEntity(HDDCreateDTO createDTO) {
        createDTO.getProductCreateDTO().setProductType(ProductType.HDD);
        Product product = productService.toEntity(createDTO.getProductCreateDTO());
        return new HDD(product, createDTO.getCapacity());
    }
}
