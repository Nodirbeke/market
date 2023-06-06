package com.example.market.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HDD extends BaseEntity {


    @OneToOne
    @JoinColumn
    private Product product;

    @Column
    private String capacity;


}
