package com.example.market.model.request;

import com.example.market.enums.ComputerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComputerCreateDTO extends BaseCreateDto{

    private ComputerType type;

}
