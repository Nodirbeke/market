package com.example.market.entity;

import com.example.market.enums.LaptopSize;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Laptop extends BaseEntityParameter{

    @Column
    @Enumerated(EnumType.STRING)
    private LaptopSize laptopSize;

    @Builder(builderMethodName = "childBuilder")
    public Laptop(Long id, Long serialNumber, Double cost, String producer, Integer count, LaptopSize laptopSize) {
        super(id, serialNumber, cost, producer, count);
        this.laptopSize = laptopSize;
    }

}
