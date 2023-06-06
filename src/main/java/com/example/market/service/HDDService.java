package com.example.market.service;

import com.example.market.entity.HDD;
import com.example.market.exception.NotFoundException;
import com.example.market.mapper.GenericMapper;
import com.example.market.model.request.HDDCreateDTO;
import com.example.market.repository.HDDRepository;
import com.example.market.service.base.AbstractService;
import com.example.market.service.base.GenericCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HDDService extends AbstractService<HDDRepository>
        implements GenericCRUDService<HDDCreateDTO, HDD, Long> {

    public HDDService(HDDRepository repository) {
        super(repository);
    }

    @Override
    public HDD create(HDDCreateDTO createDTO) {
        HDD newHDD = new HDD(createDTO.getProduct(), createDTO.getCapacity());
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

}
