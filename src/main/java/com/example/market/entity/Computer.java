package com.example.market.entity;

import com.example.market.enums.ComputerType;
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
public class Computer extends BaseEntityParameter {

    @Column
    @Enumerated(EnumType.STRING)
    private ComputerType type;

    @Builder(builderMethodName = "childBuilder")
    public Computer(Long id,
                    Long serialNumber,
                    Double cost,
                    String producer,
                    Integer count,
                    ComputerType type) {
        super(id, serialNumber, cost, producer, count);
        this.type = type;
    }
}
