package com.challenge.eshop.controller;

import com.challenge.eshop.dto.PedidoDto;
import com.challenge.eshop.service.interfaces.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/checkout")
public class PedidoController {

    private PedidoService pedidoService;

    @PostMapping()
    public ResponseEntity<PedidoDto> createPurchase(@RequestBody PedidoDto purchase){
        PedidoDto saved = pedidoService.create(purchase);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


}
