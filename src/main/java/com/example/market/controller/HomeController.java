package com.example.market.controller;

import com.example.market.entity.BaseEntity;
import com.example.market.entity.BaseEntityParameter;
import com.example.market.entity.Monitor;
import com.example.market.enums.ProductType;
import com.example.market.service.ComputerService;
import com.example.market.service.HDDService;
import com.example.market.service.LaptopService;
import com.example.market.service.MonitorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final MonitorService monitorService;
    private final LaptopService laptopService;
    private final HDDService hddService;
    private final ComputerService computerService;

    public HomeController(MonitorService monitorService,
                          LaptopService laptopService,
                          HDDService hddService,
                          ComputerService computerService) {
        this.monitorService = monitorService;
        this.laptopService = laptopService;
        this.hddService = hddService;
        this.computerService = computerService;
    }


//    @PostMapping("/products-by-type")
//    public List<T> getByProductsByType(String productType) {
//
//    }
//
//    public <T extends BaseEntityParameter> List<T> getProducts(ProductType type) {
////        return (List<BaseEntityParameter>) new ArrayList<BaseEntityParameter>();
//        return switch (type) {
//            case MONITOR -> {
//                (List<T>) new ArrayList<BaseEntityParameter>() = (List<T>) monitorService.list();
//            }
//            case LAPTOP -> laptopService.list();
//            case HDD -> hddService.list();
//            case COMPUTER -> computerService.list();
//        };
//    }
}
