package com.example.market.controller;

import com.example.market.controller.base.AbstractController;
import com.example.market.controller.base.GenericCRUDController;
import com.example.market.entity.Monitor;
import com.example.market.model.request.MonitorCreateDTO;
import com.example.market.model.response.ResponseData;
import com.example.market.service.MonitorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor")
public class MonitorController extends AbstractController<MonitorService>
        implements GenericCRUDController<MonitorCreateDTO, Monitor, Long> {

    public MonitorController(MonitorService service) {
        super(service);
    }

    @Override
    public ResponseData<Monitor> create(MonitorCreateDTO createDTO) {
        return new ResponseData<>(service.create(createDTO));
    }

    @Override
    public ResponseData<Monitor> get(Long id) {
        return new ResponseData<>(service.get(id));
    }

    @GetMapping("/get-by-product-id/{id}")
    public ResponseData<Monitor> getByProductId(@PathVariable Long id) {
        return new ResponseData<>(service.getByProductId(id));
    }

    @Override
    public ResponseData<List<Monitor>> list() {
        return new ResponseData<>(service.list());
    }

    @Override
    public ResponseData<Monitor> update(Monitor updatingEntity) {
        return new ResponseData<>(service.update(updatingEntity));
    }

    @Override
    public ResponseData<Boolean> delete(Long id) {
        return new ResponseData<>(service.delete(id));
    }
}
