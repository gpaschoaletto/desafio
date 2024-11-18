package com.challenge.eshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Produto {
    @Id
    @Column(unique = true)
    private String Sku;

    @Column
    private String nome;

    @Column
    private float preco;

    @Column
    private float saldo;

}
