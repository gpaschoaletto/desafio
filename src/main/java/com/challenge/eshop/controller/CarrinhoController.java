package com.challenge.eshop.controller;

import com.challenge.eshop.config.JwtService;
import com.challenge.eshop.dto.CarrinhoDto;
import com.challenge.eshop.dto.CriarCarrinhoRequest;
import com.challenge.eshop.dto.ProdutoDto;
import com.challenge.eshop.entity.ItensCarrinho;
import com.challenge.eshop.service.interfaces.CarrinhoService;
import com.challenge.eshop.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    private CarrinhoService carrinhoService;
    private JwtService jwtService;
    private UserService userService;

    @PostMapping()
    public ResponseEntity<CarrinhoDto> createCart(@RequestHeader("Authorization") String token){
        String email = jwtService.getEmail(token.substring(7));

        CarrinhoDto saved = carrinhoService.create(userService.getByEmail(email));

        return new ResponseEntity<>(saved, HttpStatus.CREATED);

    }

    @GetMapping("{cartId}")
    public ResponseEntity<CarrinhoDto> getCartById(@PathVariable("cartId") Long cartId, @RequestHeader("Authorization") String token){
        String email = jwtService.getEmail(token);
        CarrinhoDto CarrinhoDto = carrinhoService.getById(cartId, userService.getByEmail(email).getUserId());
        return ResponseEntity.ok(CarrinhoDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CarrinhoDto>> List(@RequestHeader("Authorization") String token){
        String email = jwtService.getEmail(token);
        return  ResponseEntity.ok(carrinhoService.list(userService.getByEmail(email).getUserId()));
    }

    @PutMapping("{cartId}")
    public ResponseEntity<CarrinhoDto> updateCart(@PathVariable("cartId") Long cartId, @RequestBody List<ItensCarrinho> listaItens,
                                                  @RequestHeader("Authorization") String token){
        String email = jwtService.getEmail(token);
        CarrinhoDto CarrinhoDto = carrinhoService.update(cartId, userService.getByEmail(email).getUserId(), listaItens);
        return ResponseEntity.ok(CarrinhoDto);
    }


}
