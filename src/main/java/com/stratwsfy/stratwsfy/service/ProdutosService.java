package com.stratwsfy.stratwsfy.service;

import com.stratwsfy.stratwsfy.controller.dto.ProdutoDto;
import com.stratwsfy.stratwsfy.controller.form.ProdutoForm;
import com.stratwsfy.stratwsfy.controller.form.ProdutoPromocaoForm;
import com.stratwsfy.stratwsfy.model.entity.Produto;
import com.stratwsfy.stratwsfy.repository.ProdutoRepository;
import com.stratwsfy.stratwsfy.repository.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutoRepository produtoRepository ;

    @Autowired
    private PromocaoRepository promocaoRepository;

    public List<ProdutoDto> getAll(String nomeProduto){

        List<Produto> produtos;
        if(nomeProduto == null) {
            produtos = produtoRepository.findAll();
        } else {
            produtos = produtoRepository.getByNome(nomeProduto);
        }
        return ProdutoDto.converter(produtos);

    }

    public ProdutoDto save(ProdutoForm produtoForm){

        Produto produto = produtoForm.converter(promocaoRepository);
        produtoRepository.save(produto);
        return new ProdutoDto(produto);

    }

    public ResponseEntity<ProdutoDto> getById(Long id){

        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()){
            return ResponseEntity.ok(new ProdutoDto(produto.get()));
        }

        return ResponseEntity.notFound().build();

    }

    public ResponseEntity<ProdutoDto> edit(ProdutoForm produtoForm, Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()){
            Produto produtoObj = produtoForm.atualizar(id, produtoRepository);
            return ResponseEntity.ok(new ProdutoDto(produtoObj));
        }
        return ResponseEntity.notFound().build();

    }

    public ResponseEntity<String> delete(Long id){

        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()){
            produtoRepository.delete(produto.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }

    public ResponseEntity<ProdutoDto> associarPromocao(ProdutoPromocaoForm produtoPromocaoForm, Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()){
            Produto produtoObj = produtoPromocaoForm.atualizar(id, produtoRepository, promocaoRepository);
            return ResponseEntity.ok(new ProdutoDto(produtoObj));
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ProdutoDto> removerPromocao(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()){
            produto.get().setPromocao(null);
            return ResponseEntity.ok(new ProdutoDto(produto.get()));
        }

        return ResponseEntity.notFound().build();

    }

}
