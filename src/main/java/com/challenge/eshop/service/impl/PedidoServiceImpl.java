package com.challenge.eshop.service.impl;

import com.challenge.eshop.dto.PedidoDto;
import com.challenge.eshop.entity.Pedido;
import com.challenge.eshop.entity.Produto;
import com.challenge.eshop.mapper.PedidoMapper;
import com.challenge.eshop.mapper.ProdutoMapper;
import com.challenge.eshop.repository.PedidoRepository;
import com.challenge.eshop.service.interfaces.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;

    @Override
    public PedidoDto create(PedidoDto pedidoDto) {

        Pedido pedido = PedidoMapper.mapToEntity(pedidoDto);

        Pedido saved = pedidoRepository.save(pedido);

        return PedidoMapper.mapToDto(saved);
    }

}
