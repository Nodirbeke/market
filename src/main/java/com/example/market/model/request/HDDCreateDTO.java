package com.example.market.model.request;

import com.example.market.entity.Auditable;
import com.example.market.entity.Product;
import com.example.market.model.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HDDCreateDTO implements BaseDTO {

    private ProductCreateDTO productCreateDTO;

    private String capacity;

}
