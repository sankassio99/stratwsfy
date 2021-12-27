package com.stratwsfy.stratwsfy.controller.dto;

import com.stratwsfy.stratwsfy.model.entity.Produto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ItemCarrinhoDto {

    private Long idProduto;
    private String produto;
    private int quantidade;
    private double precoUnitario;
    private double precoTotal;
    private String promocao;

    public ItemCarrinhoDto converter(Produto produto) {
        this.idProduto = produto.getId();
        this.precoUnitario = produto.getValor();
        this.produto = produto.getNome();

        if(produto.getPromocao() !=null)
            this.promocao = produto.getPromocao().getNome();

        this.quantidade = 1;
        this.precoTotal = calculaPrecoTotal(produto);

        return this;
    }

    public void addQuantidade(Produto produto) {
        this.quantidade = this.quantidade + 1 ;
        this.precoTotal = calculaPrecoTotal(produto);
    }

    public void removeQuantidade(Produto produto) {
        this.quantidade = this.quantidade - 1 ;
        this.precoTotal = calculaPrecoTotal(produto);
    }

    public double calculaPrecoTotal(Produto produto){

        double total = produto.getValor() * this.quantidade;
        if(produto.getPromocao() != null){
            total = produto.getPromocao().aplicarPromocao(this.quantidade, total);
        }
        return total ;
    }


}
