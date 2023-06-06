package com.example.market.service;

import com.example.market.entity.*;
import com.example.market.enums.ProductType;
import com.example.market.exception.NotFoundException;
import com.example.market.mapper.GenericMapper;
import com.example.market.model.request.ProductCreateDTO;
import com.example.market.repository.ProductRepository;
import com.example.market.service.base.AbstractService;
import com.example.market.service.base.GenericCRUDService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends AbstractService<ProductRepository>
        implements GenericCRUDService<ProductCreateDTO, Product, Long>,
        GenericMapper<Product, ProductCreateDTO> {

    private final HDDService hddService;
    private final MonitorService monitorService;
    private final LaptopService laptopService;

    private final ComputerService computerService;

    public ProductService(ProductRepository repository, HDDService hddService, MonitorService monitorService, LaptopService laptopService, ComputerService computerService) {
        super(repository);
        this.hddService = hddService;
        this.monitorService = monitorService;
        this.laptopService = laptopService;
        this.computerService = computerService;
    }


    @Override
    public Product create(ProductCreateDTO createDTO) {
        Product computer = new Product(createDTO.getSerialNumber(),
                createDTO.getCost(),
                createDTO.getProducer(),
                createDTO.getCount(),
                createDTO.getProductType());
        Product newProduct = repository.save(computer);
        return newProduct;
    }

    @Override
    @Transactional
    public Product get(Long key) {
        Optional<Product> computerOptional = repository.findById(key);
        return computerOptional.orElseThrow(() -> new NotFoundException("PRODUCT_NOT_FOUND"));
    }

    @Override
    public List<Product> list() {
        List<Product> products = repository.findAll();
        return products;
    }

    @Override
    public Product update(Product updatingEntity) {
        get(updatingEntity.getId());
        Product updatedProduct = repository.save(updatingEntity);
        return updatedProduct;
    }

    @Override
    public Boolean delete(Long key) {
        repository.deleteById(key);
        return Boolean.TRUE;
    }


    public List getAllByProductType(ProductType type) {
        switch (type) {
            case COMPUTER -> {
                return computerService.list();
            }
            case MONITOR -> {
                return monitorService.list();
            }
            case HDD -> {
                return hddService.list();
            }
            case LAPTOP -> {
                return laptopService.list();
            }
            default -> throw new RuntimeException("UNSUPPORTED_PRODUCT_TYPE");
        }

    }

    @Override
    public Product toEntity(ProductCreateDTO createDTO) {
        return new Product(createDTO.getSerialNumber(),
                createDTO.getCost(),
                createDTO.getProducer(),
                createDTO.getCount(),
                createDTO.getProductType());
    }
}
