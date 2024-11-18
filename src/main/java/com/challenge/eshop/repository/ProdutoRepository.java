package com.challenge.eshop.repository;

import com.challenge.eshop.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(value = "SELECT * FROM produto where sku = ? ", nativeQuery = true)
    public Optional<Produto> findBySku(String Sku);
}
