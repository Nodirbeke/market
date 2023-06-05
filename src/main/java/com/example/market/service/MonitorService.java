package com.example.market.service;

import com.example.market.entity.Monitor;
import com.example.market.exception.NotFoundException;
import com.example.market.mapper.GenericMapper;
import com.example.market.model.request.MonitorCreateDTO;
import com.example.market.repository.MonitorRepository;
import com.example.market.service.base.AbstractService;
import com.example.market.service.base.GenericCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorService extends AbstractService<MonitorRepository>
        implements GenericCRUDService<MonitorCreateDTO, Monitor, Long>,
        GenericMapper<Monitor, MonitorCreateDTO> {

    public MonitorService(MonitorRepository repository) {
        super(repository);
    }

    @Override
    public Monitor create(MonitorCreateDTO createDTO) {
        Monitor creatingMonitor = toEntity(createDTO);
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

    @Override
    public Monitor toEntity(MonitorCreateDTO createDTO) {
        return Monitor.childBuilder()
                .cost(createDTO.getCost())
                .count(createDTO.getCount())
                .producer(createDTO.getProducer())
                .diameter(createDTO.getDiameter())
                .serialNumber(createDTO.getSerialNumber())
                .build();

    }
}
