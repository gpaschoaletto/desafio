package com.challenge.eshop.service.interfaces;

import com.challenge.eshop.dto.*;
import com.challenge.eshop.entity.ItensCarrinho;

import java.util.List;

public interface CarrinhoService {
    CarrinhoDto create(UserDto user);

    CarrinhoDto getById(long cartId, long userId);

    List<CarrinhoDto> list(long userId);

    CarrinhoDto update(long cartId,long userId, List<ItensCarrinho> listaItens);

    PedidoDto checkout(long cartId, long userId);
}
