package com.stratwsfy.stratwsfy.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.stratwsfy.stratwsfy.model.TiposPromocao;
import com.stratwsfy.stratwsfy.model.entity.Promocao;
import lombok.Data;

@Data
public class PromocaoDto {
	
	private Long id;
	private String nome;
	private String descricao;
	private String calculo;
	private TiposPromocao tipoPromocao;
//	private List<Produto> produtos;
	
	public PromocaoDto(Promocao promocao) {
		this.id = promocao.getId();
		this.nome = promocao.getNome();
		this.descricao = promocao.getDescricao();
		this.calculo = promocao.getCalculo();
//		this.produtos = promocao.getProdutos();
		this.tipoPromocao = promocao.getTipoPromocao();
	}
	
	public static List<PromocaoDto> converter(List<Promocao> promocao) {
		return promocao.stream().map(PromocaoDto::new).collect(Collectors.toList());
	}
	
}
