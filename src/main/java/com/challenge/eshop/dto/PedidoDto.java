package com.challenge.eshop.dto;

import com.challenge.eshop.entity.Carrinho;
import com.challenge.eshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {
    private long pedidoId;
    private User user;
    private Carrinho carrinho;
}
