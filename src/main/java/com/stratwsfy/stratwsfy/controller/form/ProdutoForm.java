package com.stratwsfy.stratwsfy.controller.form;

import com.stratwsfy.stratwsfy.model.entity.Produto;
import com.stratwsfy.stratwsfy.model.entity.Promocao;
import com.stratwsfy.stratwsfy.repository.ProdutoRepository;
import com.stratwsfy.stratwsfy.repository.PromocaoRepository;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProdutoForm {
	
	private Long id;
	@NotNull @NotBlank
	private String nome;
	@DecimalMin("0.1")
	private double valor;
	private Long promocao_id;
	
	public Produto converter(PromocaoRepository promocaoRepository) {
		if(this.promocao_id == null){
			return new Produto(this.nome, this.valor);
		}

		Promocao promocao = promocaoRepository.getById(this.promocao_id);
		return new Produto(this.nome, this.valor, promocao);
	}

	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.getById(id);
		
		produto.setNome(this.nome);
		produto.setValor(this.valor);
		
		return produto;
	}
}
