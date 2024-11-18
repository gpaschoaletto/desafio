package com.challenge.eshop.repository;

import com.challenge.eshop.entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    @Query(value = "SELECT * FROM carrinho where userId = ? ", nativeQuery = true)
    public List<Carrinho> FindByUserId(long userId);

    @Query(value = "Select * from carrinho where cartId = ?1 and userId = ?2", nativeQuery = true)
    public Optional<Carrinho> FindByCartIdAndUserId(long cartId, long userId);

}
