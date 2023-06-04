package com.example.market.controller;

import com.example.market.controller.base.AbstractController;
import com.example.market.controller.base.GenericCRUDController;
import com.example.market.model.request.ComputerCreateDTO;
import com.example.market.model.response.ResponseData;
import com.example.market.entity.Computer;
import com.example.market.service.ComputerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/computer")
public class ComputerController extends AbstractController<ComputerService>
        implements GenericCRUDController<ComputerCreateDTO, Computer, Long> {


    public ComputerController(ComputerService service) {
        super(service);
    }

    @Override
    public ResponseData<Computer> create(ComputerCreateDTO createDTO) {
        return new ResponseData<>(service.create(createDTO));
    }

    @Override
    public ResponseData<Computer> get(Long id) {
        return new ResponseData<>(service.get(id));
    }

    @Override
    public ResponseData<List<Computer>> list() {
        return new ResponseData<>(service.list());
    }

    @Override
    public ResponseData<Computer> update(Computer entity) {
        return new ResponseData<>(service.update(entity));
    }

    @Override
    public ResponseData<Boolean> delete(Long id) {
        return new ResponseData<>(service.delete(id));
    }
}
