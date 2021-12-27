package com.stratwsfy.stratwsfy.service;

import com.stratwsfy.stratwsfy.controller.dto.CarrinhoDto;
import com.stratwsfy.stratwsfy.controller.dto.ItemCarrinhoDto;
import com.stratwsfy.stratwsfy.model.entity.Produto;
import com.stratwsfy.stratwsfy.repository.ProdutoRepository;
import com.stratwsfy.stratwsfy.repository.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PromocaoRepository promocaoRepository;

    public ResponseEntity<CarrinhoDto> add(List<ItemCarrinhoDto> itensCarrinho, Long id){

        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isPresent()){

            for (ItemCarrinhoDto item : itensCarrinho) {
                if(item.getIdProduto().equals(produto.get().getId())){
                    item.addQuantidade(produto.get());
                    return ResponseEntity.ok(new CarrinhoDto(itensCarrinho));
                }
            }

            itensCarrinho.add(new ItemCarrinhoDto().converter(produto.get()));
            return ResponseEntity.ok(new CarrinhoDto(itensCarrinho));
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<CarrinhoDto> remove(List<ItemCarrinhoDto> itensCarrinho, Long id){

        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isPresent()){

            for (ItemCarrinhoDto item : itensCarrinho) {
                if(item.getIdProduto().equals(produto.get().getId())){
                    if(item.getQuantidade() > 1){
                        item.removeQuantidade(produto.get());
                        break;
                    }else if(item.getQuantidade() == 1){
                        itensCarrinho.remove(item);
                        break;
                    }
                }
            }

            return ResponseEntity.ok(new CarrinhoDto(itensCarrinho));
        }

        return ResponseEntity.notFound().build();
    }

}
