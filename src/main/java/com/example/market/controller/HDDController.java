package com.example.market.controller;

import com.example.market.controller.base.AbstractController;
import com.example.market.controller.base.GenericCRUDController;
import com.example.market.entity.HDD;
import com.example.market.model.request.HDDCreateDTO;
import com.example.market.model.response.ResponseData;
import com.example.market.service.HDDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hdd")
public class HDDController extends AbstractController<HDDService>
        implements GenericCRUDController<HDDCreateDTO, HDD, Long> {
    public HDDController(HDDService service) {
        super(service);
    }

    @Override
    public ResponseData<HDD> create(HDDCreateDTO createDTO) {
        return new ResponseData<>(service.create(createDTO));
    }

    @Override
    public ResponseData<HDD> get(Long id) {
        return new ResponseData<>(service.get(id));
    }

    @Override
    public ResponseData<List<HDD>> list() {
        return new ResponseData<>(service.list());
    }

    @Override
    public ResponseData<HDD> update(HDD updatingEntity) {
        return new ResponseData<>(service.update(updatingEntity));
    }

    @Override
    public ResponseData<Boolean> delete(Long id) {
        return new ResponseData<>(service.delete(id));
    }
}
