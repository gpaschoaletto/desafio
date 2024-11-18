package com.challenge.eshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Carrinho {
    @Id
    @GeneratedValue
    private long cartId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy="cart")
    private List<ItensCarrinho> listaProdutos;

    @OneToOne
    private long pedidoId;

}


