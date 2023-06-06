package com.example.market.entity;

import com.example.market.enums.ProductType;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends Auditable {

    @Column
    private Long serialNumber;

    @Column
    private Double cost;

    @Column
    private String producer;

    @Column
    private Integer count;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    public Product(Long serialNumber, Double cost, String producer, Integer count, ProductType productType) {
        this.serialNumber = serialNumber;
        this.cost = cost;
        this.producer = producer;
        this.count = count;
        this.productType = productType;
    }
}
