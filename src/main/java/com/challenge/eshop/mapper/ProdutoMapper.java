package com.challenge.eshop.mapper;

import com.challenge.eshop.dto.ProdutoDto;
import com.challenge.eshop.entity.Produto;

public class ProdutoMapper {
    public static ProdutoDto mapToDto(Produto produto){
        return new ProdutoDto(
            produto.getSku(),
            produto.getNome(),
            produto.getPreco(),
            produto.getSaldo()
        );
    }

    public static Produto mapToEntity(ProdutoDto produtoDto){
        return new Produto(
            produtoDto.getSku(),
            produtoDto.getNome(),
            produtoDto.getPreco(),
            produtoDto.getSaldo()
        );
    }
}
