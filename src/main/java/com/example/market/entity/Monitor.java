package com.example.market.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Monitor extends BaseEntityParameter{

    @Column
    private Integer diameter;

    @Builder(builderMethodName = "childBuilder")
    public Monitor(Long id, Long serialNumber, Double cost, String producer, Integer count, Integer diameter) {
        super(id, serialNumber, cost, producer, count);
        this.diameter = diameter;
    }
}
