package com.example.market.service;

import com.example.market.entity.Monitor;
import com.example.market.entity.Product;
import com.example.market.enums.ProductType;
import com.example.market.exception.NotFoundException;
import com.example.market.mapper.GenericMapper;
import com.example.market.model.request.MonitorCreateDTO;
import com.example.market.repository.MonitorRepository;
import com.example.market.service.base.AbstractService;
import com.example.market.service.base.GenericCRUDService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MonitorService extends AbstractService<MonitorRepository>
        implements GenericCRUDService<MonitorCreateDTO, Monitor, Long>,
        GenericMapper<Monitor, MonitorCreateDTO> {

    private final ProductService productService;

    public MonitorService(MonitorRepository repository,
                          @Lazy ProductService productService) {
        super(repository);
        this.productService = productService;
    }

    @Override
    @Transactional
    public Monitor create(MonitorCreateDTO createDTO) {
        Product product = productService.create(createDTO.getProductCreateDTO());
        Monitor creatingMonitor = new Monitor(product, createDTO.getDyum());
        Monitor newMonitor = repository.save(creatingMonitor);
        return newMonitor;
    }

    @Override
    public Monitor get(Long key) {
        return repository.findById(key)
                .orElseThrow(() ->
                        new NotFoundException("MONITOR_NOT_FOUND"));
    }

    @Override
    public List<Monitor> list() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Monitor update(Monitor updatingEntity) {
        get(updatingEntity.getId());
        Monitor updatedMonitor = repository.save(updatingEntity);
        return updatedMonitor;
    }

    @Override
    public Boolean delete(Long key) {
        repository.deleteById(key);
        return Boolean.TRUE;
    }

    public Monitor getByProductId(Long id) {
        Product product = productService.get(id);
        return repository.findByProduct(product)
                .orElseThrow(() ->
                        new NotFoundException("MONITOR_NOT_FOUND"));
    }

    @Override
    public Monitor toEntity(MonitorCreateDTO createDTO) {
        createDTO.getProductCreateDTO().setProductType(ProductType.COMPUTER);
        Product product = productService.toEntity(createDTO.getProductCreateDTO());
        return new Monitor(product, createDTO.getDyum());
    }
}
