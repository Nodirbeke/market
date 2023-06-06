package com.example.market.entity;

import com.example.market.enums.ComputerType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Computer extends BaseEntity {

    @OneToOne
    @JoinColumn
    private Product product;

    @Column
    @Enumerated(EnumType.STRING)
    private ComputerType type;

}
