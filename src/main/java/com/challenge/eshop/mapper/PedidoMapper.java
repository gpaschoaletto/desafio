package com.challenge.eshop.mapper;

import com.challenge.eshop.dto.CarrinhoDto;
import com.challenge.eshop.dto.PedidoDto;
import com.challenge.eshop.entity.Carrinho;
import com.challenge.eshop.entity.Pedido;

public class PedidoMapper {

    public static PedidoDto mapToDto(Pedido pedido){
        return new PedidoDto(
                pedido.getPedidoId(),
                pedido.getUser(),
                pedido.getCarrinho()
        );
    }

    public static Pedido mapToEntity(PedidoDto pedidoDto){
        return new Pedido(
                pedidoDto.getPedidoId(),
                pedidoDto.getUser(),
                pedidoDto.getCarrinho()
        );
    }
}
