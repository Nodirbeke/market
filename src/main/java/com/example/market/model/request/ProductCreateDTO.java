package com.example.market.model.request;

import com.example.market.enums.ProductType;
import com.example.market.model.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDTO implements BaseDTO {

    private Long serialNumber;

    private Double cost;

    private String producer;

    private Integer count;

    private ProductType type;

    private MonitorCreateDTO monitorCreateDTO;
    private HDDCreateDTO hddCreateDTO;
    private LaptopCreateDTO laptopCreateDTO;
    private ComputerCreateDTO computerCreateDTO;

}
