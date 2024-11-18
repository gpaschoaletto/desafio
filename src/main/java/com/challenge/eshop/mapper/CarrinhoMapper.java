package com.challenge.eshop.mapper;

import com.challenge.eshop.dto.CarrinhoDto;
import com.challenge.eshop.entity.Carrinho;

public class CarrinhoMapper {
    public static CarrinhoDto mapToDto(Carrinho carrinho){
        return new CarrinhoDto(
            carrinho.getCartId(),
            carrinho.getUser(),
            carrinho.getListaProdutos(),
            carrinho.getPedido()
        );
    }

    public static Carrinho mapToEntity(CarrinhoDto carrinhoDto){
        return new Carrinho(
            carrinhoDto.getCartId(),
            carrinhoDto.getUser(),
            carrinhoDto.getListaProdutos(),
            carrinhoDto.getPedido()
        );
    }
}
