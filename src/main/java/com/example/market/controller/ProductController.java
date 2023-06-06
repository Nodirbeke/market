package com.example.market.controller;

import com.example.market.controller.base.AbstractController;
import com.example.market.controller.base.GenericCRUDController;
import com.example.market.entity.Product;
import com.example.market.model.request.ProductCreateDTO;
import com.example.market.model.response.ResponseData;
import com.example.market.service.ComputerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/computer")
public class ProductController extends AbstractController<ComputerService>
        implements GenericCRUDController<ProductCreateDTO, Product, Long> {



    public ProductController(ComputerService service) {
        super(service);
    }



    @Override
    public ResponseData<Product> create(ProductCreateDTO createDTO) {
        return new ResponseData<>(service.create(createDTO));
    }

    @Override
    public ResponseData<Product> get(Long id) {
        return new ResponseData<>(service.get(id));
    }

    @Override
    public ResponseData<List<Product>> list() {
        return new ResponseData<>(service.list());
    }

    @Override
    public ResponseData<Product> update(Product updatingEntity) {
        return new ResponseData<>(service.update(updatingEntity));
    }

    @Override
    public ResponseData<Boolean> delete(Long id) {
        return new ResponseData<>(service.delete(id));
    }
}
