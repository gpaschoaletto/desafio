package com.challenge.eshop.controller;

import com.challenge.eshop.dto.ProdutoDto;
import com.challenge.eshop.service.interfaces.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    @PostMapping()
    public ResponseEntity<ProdutoDto> createProduct(@RequestBody ProdutoDto product){
        ProdutoDto saved = produtoService.create(product);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProdutoDto> getProductById(@PathVariable("productId") String sku){
        ProdutoDto ProdutoDto = produtoService.getById(sku);
        return ResponseEntity.ok(ProdutoDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProdutoDto>> List(){
        return  ResponseEntity.ok(produtoService.list());
    }

    //TODO regra de negocio (saldo negativo, preco zero)
    @PutMapping("{productId}")
    public ResponseEntity<ProdutoDto> updateProduct(@PathVariable("productId") String sku, @RequestBody ProdutoDto updated){
        ProdutoDto ProdutoDto = produtoService.update(sku, updated);
        return ResponseEntity.ok(ProdutoDto);
    }

}
