package com.example.market.entity;

import com.example.market.enums.ProductType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    @Column
    private Long serialNumber;

    @Column
    private Double cost;

    @Column
    private String producer;

    @Column
    private Integer count;

    private ProductType productType;

    @OneToOne
    private Monitor monitor;

    @OneToOne
    private Laptop laptop;

    @OneToOne
    private HDD hdd;

    @OneToOne
    private Computer computer;

}
