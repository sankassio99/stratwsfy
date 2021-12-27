package com.stratwsfy.stratwsfy.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.stratwsfy.stratwsfy.model.TiposPromocao;
import com.stratwsfy.stratwsfy.model.entity.Produto;
import lombok.Data;

@Data
public class ProdutoDto {
	
	private Long id;
	private String nome;
	private double valor;
	private TiposPromocao promocao;
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.valor = produto.getValor();

		if(produto.getPromocao() != null)
			this.promocao = produto.getPromocao().getTipoPromocao();
	}

	public ProdutoDto(){}

	public static List<ProdutoDto> converter(List<Produto> produtos) {
		// como se fosse um for onde ele vai gerando um dto de cada produto recebido
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());

	}



	
}
