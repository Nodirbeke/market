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
public class HDD extends BaseEntityParameter {

    @Column
    private String capacity;

    @Builder(builderMethodName = "childBuilder")
    public HDD(Long id, Long serialNumber, Double cost, String producer, Integer count, String capacity) {
        super(id, serialNumber, cost, producer, count);
        this.capacity = capacity;
    }

}
