package com.example.market.controller;

import com.example.market.controller.base.AbstractController;
import com.example.market.controller.base.GenericCRUDController;
import com.example.market.entity.Laptop;
import com.example.market.model.request.LaptopCreateDTO;
import com.example.market.model.response.ResponseData;
import com.example.market.service.LaptopService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController extends AbstractController<LaptopService>
        implements GenericCRUDController<LaptopCreateDTO, Laptop, Long> {
    public LaptopController(LaptopService service) {
        super(service);
    }

    @Override
    public ResponseData<Laptop> create(LaptopCreateDTO createDTO) {
        return new ResponseData<>(service.create(createDTO));
    }

    @Override
    public ResponseData<Laptop> get(Long id) {
        return new ResponseData<>(service.get(id));
    }

    @Override
    public ResponseData<List<Laptop>> list() {
        return new ResponseData<>(service.list());
    }

    @Override
    public ResponseData<Laptop> update(Laptop updatingEntity) {
        return new ResponseData<>(service.update(updatingEntity));
    }

    @Override
    public ResponseData<Boolean> delete(Long id) {
        return new ResponseData<>(service.delete(id));
    }

}
