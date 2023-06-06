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
public class Laptop extends Auditable {


    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Product product;

    @Column
    @Enumerated(EnumType.STRING)
    private LaptopSize laptopSize;


}
