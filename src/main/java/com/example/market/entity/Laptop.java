package com.example.market.entity;

import com.example.market.enums.LaptopSize;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Laptop extends BaseEntity {


    @OneToOne
    @JoinColumn
    private Product product;

    @Column
    @Enumerated(EnumType.STRING)
    private LaptopSize laptopSize;


}
