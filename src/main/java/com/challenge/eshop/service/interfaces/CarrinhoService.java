package com.challenge.eshop.service.interfaces;

import com.challenge.eshop.dto.*;

import java.util.List;

public interface CarrinhoService {
    CarrinhoDto create(UserDto user);

    CarrinhoDto getById(long cartId, long userId);

    List<CarrinhoDto> list(long userId);

    CarrinhoDto update(long cartId,long userId, List<ProdutoDto> produtos);

    PedidoDto checkout(long cartId, long userId);
}
