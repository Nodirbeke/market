package com.example.market.service;

import com.example.market.entity.*;
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
        Product computer = toEntity(createDTO);
        Product product = repository.save(computer);
        Product newProduct = createProductType(createDTO, product);
        return newProduct;
    }

    private Product createProductType(ProductCreateDTO createDTO, Product product) {
        switch (createDTO.getType()) {
            case HDD -> {
                createDTO.getHddCreateDTO().setProduct(product);
                HDD hdd = hddService.create(createDTO.getHddCreateDTO());
                product.setHdd(hdd);
                return product;
            }
            case LAPTOP -> {
                createDTO.getLaptopCreateDTO().setProduct(product);
                Laptop laptop = laptopService.create(createDTO.getLaptopCreateDTO());
                product.setLaptop(laptop);
                return product;
            }
            case MONITOR -> {
                createDTO.getMonitorCreateDTO().setProduct(product);
                Monitor monitor = monitorService.create(createDTO.getMonitorCreateDTO());
                product.setMonitor(monitor);
                return product;
            }
            case COMPUTER -> {
                createDTO.getComputerCreateDTO().setProduct(product);
                Computer computer = computerService.create(createDTO.getComputerCreateDTO());
                product.setComputer(computer);
                return product;
            }
            default -> throw new RuntimeException("UNSUPPORTED_PRODUCT_TYPE");
        }
    }

       private List setLaptop(ProductCreateDTO createDTO, Product product) {
        return switch (createDTO.getType()) {
            case HDD -> {
                 hddService.list();
                 }
            case LAPTOP -> {
                createDTO.getLaptopCreateDTO().setProduct(product);
                Laptop laptop = laptopService.create(createDTO.getLaptopCreateDTO());
                product.setLaptop(laptop);
                return product;
            }
            case MONITOR -> {
                createDTO.getMonitorCreateDTO().setProduct(product);
                Monitor monitor = monitorService.create(createDTO.getMonitorCreateDTO());
                product.setMonitor(monitor);
                return product;
            }
            case COMPUTER -> {
                createDTO.getComputerCreateDTO().setProduct(product);
                Computer computer = computerService.create(createDTO.getComputerCreateDTO());
                product.setComputer(computer);
                return product;
            }
            default -> throw new RuntimeException("UNSUPPORTED_PRODUCT_TYPE");
        }
    }



    @Override
    @Transactional
    public Product get(Long key) {
        Optional<Product> computerOptional = repository.findById(key);
        return computerOptional.orElseThrow(() -> new NotFoundException("COMPUTER_NOT_FOUND"));
    }

    @Override
    public List<Product> list() {
        List<Product> computers = repository.findAll();
        return computers;
    }

    @Override
    public Product update(Product updatingEntity) {
        get(updatingEntity.getId());
        Product updatedProduct = repository.save(updatingEntity);
        return Product;
    }

    @Override
    public Boolean delete(Long key) {
        repository.deleteById(key);
        return Boolean.TRUE;
    }

    @Override
    public Product toEntity(ProductCreateDTO createDTO) {
        return Product.childBuilder()
                .cost(createDTO.getCost())
                .type(createDTO.getType())
                .count(createDTO.getCount())
                .producer(createDTO.getProducer())
                .serialNumber(createDTO.getSerialNumber())
                .build();
    }
}
