package com.challenge.eshop.service.impl;

import com.challenge.eshop.dto.ProdutoDto;
import com.challenge.eshop.entity.Produto;
import com.challenge.eshop.exception.ResourceNotFoundException;
import com.challenge.eshop.mapper.ProdutoMapper;
import com.challenge.eshop.repository.ProdutoRepository;
import com.challenge.eshop.service.interfaces.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;

    @Override
    public ProdutoDto create(ProdutoDto produtoDto) {
        Produto produto = ProdutoMapper.mapToEntity(produtoDto);
        if(!produtoRepository.findBySku(produto.getSku()).isEmpty()){
            throw new RuntimeException(String.format("Produto já cadastrado"));
        }
        if(produto.getSaldo() < 0) {
            throw new RuntimeException(String.format("Saldo não pode ser negativo"));
        }
        if(produto.getPreco() <= 0){
            throw new RuntimeException(String.format("Preço não pode ser igual ou menor a zero"));
        }

        Produto saved = produtoRepository.save(produto);

        return ProdutoMapper.mapToDto(saved);
    }

    @Override
    public ProdutoDto getById(String sku) {
        Produto produto = produtoRepository.findBySku(sku)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado: " + sku));
        return ProdutoMapper.mapToDto(produto);
    }

    @Override
    public ProdutoDto update(String sku, ProdutoDto produtoDto) {
        Produto produto = produtoRepository.findBySku(sku)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado: " + sku));

        if (produtoDto.getSku().equals(sku)){
            produto.setNome(produtoDto.getNome());
            produto.setPreco(produtoDto.getPreco());
            produto.setSaldo(produtoDto.getSaldo());

            Produto updated = produtoRepository.save(produto);

            return ProdutoMapper.mapToDto(updated);
        }

        return null;
    }

    @Override
    public List<ProdutoDto> list() {
        List<Produto> produtoList = produtoRepository.findAll();
        return produtoList.stream().filter( p -> p.getSaldo() > 0)
                .map(user -> ProdutoMapper.mapToDto(user))
                .collect(Collectors.toList());
    }

}
