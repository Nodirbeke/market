package com.example.market.model.request;

import com.example.market.model.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonitorCreateDTO implements BaseDTO {

    private ProductCreateDTO productCreateDTO;
    private Integer dyum;

}
