package com.example.market.model.request;

import com.example.market.enums.LaptopSize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaptopCreateDTO extends BaseCreateDto {

    private LaptopSize laptopSize;

}
