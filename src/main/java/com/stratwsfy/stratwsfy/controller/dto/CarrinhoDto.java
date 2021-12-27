package com.stratwsfy.stratwsfy.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class CarrinhoDto {

    private List<ItemCarrinhoDto> itens;
    private double total;

    public CarrinhoDto(List<ItemCarrinhoDto> itens) {
        this.itens = itens ;
        this.total = calculaTotal();
    }

    private double calculaTotal() {

        double total = 0.0 ;
        for (ItemCarrinhoDto item : this.itens) {
            total = total + item.getPrecoTotal();
        }

        return total ;
    }

}
