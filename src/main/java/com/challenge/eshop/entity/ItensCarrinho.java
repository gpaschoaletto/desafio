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
public class ItensCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idItensCarrinho;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="cartId", nullable=false)
    private Carrinho carrinho;

    @Column
    private long produtoId;

    @Column
    private float quantidade;

}
