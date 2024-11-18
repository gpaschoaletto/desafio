package com.challenge.eshop.service.impl;

import com.challenge.eshop.dto.*;
import com.challenge.eshop.entity.Carrinho;
import com.challenge.eshop.entity.ItensCarrinho;
import com.challenge.eshop.exception.ResourceNotFoundException;
import com.challenge.eshop.mapper.CarrinhoMapper;
import com.challenge.eshop.mapper.ProdutoMapper;
import com.challenge.eshop.mapper.UserMapper;
import com.challenge.eshop.repository.CarrinhoRepository;
import com.challenge.eshop.service.interfaces.CarrinhoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarrinhoServiceImpl implements CarrinhoService {
    
    private CarrinhoRepository carrinhoRepository;

    @Override
    public CarrinhoDto create(UserDto user) {
        Carrinho carrinho = new Carrinho();
        carrinho.setUser(UserMapper.mapToEntity(user));

        Carrinho saved = carrinhoRepository.save(carrinho);

        return CarrinhoMapper.mapToDto(saved);
    }

    @Override
    public CarrinhoDto getById(long cartId, long userId) {
        Carrinho carrinho = carrinhoRepository.FindByCartIdAndUserId(cartId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Carrinho não encotrado: " + cartId));
        return CarrinhoMapper.mapToDto(carrinho);
    }

    @Override
    public List<CarrinhoDto> list(long userId) {
        return List.of();
    }

    @Override
    public PedidoDto checkout(long cartId, long userId) {
        return null;
    }

    @Override
    public CarrinhoDto update(long cartId, long userId, List<ItensCarrinho> listaItens) {
        Carrinho carrinho = carrinhoRepository.FindByCartIdAndUserId(cartId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Carrinho não encotrado: " + cartId));

        carrinho.setListaItens(listaItens);

        Carrinho updated = carrinhoRepository.save(carrinho);

        return CarrinhoMapper.mapToDto(updated);
    }
}
