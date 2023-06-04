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
public class BaseCreateDto implements BaseDTO {

    private Long serialNumber;

    private Double cost;

    private String producer;

    private Integer count;

}
