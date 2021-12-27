package com.stratwsfy.stratwsfy.controller;


import com.stratwsfy.stratwsfy.controller.dto.CarrinhoDto;
import com.stratwsfy.stratwsfy.controller.dto.ItemCarrinhoDto;
import com.stratwsfy.stratwsfy.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carrinho")
@Scope(value = "session")
public class CarrinhoController {

    private List<ItemCarrinhoDto> itensCarrinho = new ArrayList<>();

    @Autowired
    CarrinhoService carrinhoService;

    @GetMapping
    public CarrinhoDto consultarCarrinho(){
        return new CarrinhoDto(itensCarrinho);
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<CarrinhoDto> add(@PathVariable Long id){
        return carrinhoService.add(itensCarrinho, id);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<CarrinhoDto> remove(@PathVariable Long id){
        return carrinhoService.remove(itensCarrinho, id);
    }
}
