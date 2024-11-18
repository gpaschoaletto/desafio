package com.challenge.eshop.dto;

import com.challenge.eshop.entity.ItensCarrinho;
import com.challenge.eshop.entity.Pedido;
import com.challenge.eshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoDto {

    private long cartId;
    private User user;
    private List<ItensCarrinho> listaItens;
    private Pedido pedido;

}
