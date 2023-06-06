package com.example.market.controller;

import com.example.market.controller.base.AbstractController;
import com.example.market.enums.ProductType;
import com.example.market.model.response.ResponseData;
import com.example.market.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends AbstractController<ProductService> {

    public ProductController(ProductService service) {
        super(service);
    }

    @GetMapping("/get-all-by-type/{type}")
    public ResponseData<List> getAllByProductType(@PathVariable ProductType type) {
        return new ResponseData<>(service.getAllByProductType(type));
    }
}
