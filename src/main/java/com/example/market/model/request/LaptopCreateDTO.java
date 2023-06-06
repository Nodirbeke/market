package com.example.market.model.request;

import com.example.market.entity.Product;
import com.example.market.enums.LaptopSize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaptopCreateDTO extends ProductCreateDTO {
    private Product product;

    private LaptopSize laptopSize;

}
