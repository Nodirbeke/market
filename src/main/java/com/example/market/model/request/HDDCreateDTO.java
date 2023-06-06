package com.example.market.model.request;

import com.example.market.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HDDCreateDTO extends ProductCreateDTO {
    private Product product;

    private String capacity;

}
