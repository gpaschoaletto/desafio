package com.challenge.eshop.service.interfaces;

import com.challenge.eshop.dto.ProdutoDto;

import java.util.List;

public interface ProdutoService {
    ProdutoDto create(ProdutoDto product);

    ProdutoDto getById(String sku);

    List<ProdutoDto> list();

    ProdutoDto update(String sku, ProdutoDto updatedProduct);
}
