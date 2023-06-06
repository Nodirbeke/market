package com.example.market.model.request;

import com.example.market.enums.ProductType;
import com.example.market.model.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateDTO implements BaseDTO {

    private Long serialNumber;

    private Double cost;

    private String producer;

    private Integer count;

    private ProductType productType;

}
