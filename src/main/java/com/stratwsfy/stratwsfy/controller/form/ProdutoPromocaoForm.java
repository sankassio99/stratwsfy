package com.stratwsfy.stratwsfy.controller.form;

import com.stratwsfy.stratwsfy.model.entity.Produto;
import com.stratwsfy.stratwsfy.model.entity.Promocao;
import com.stratwsfy.stratwsfy.repository.ProdutoRepository;
import com.stratwsfy.stratwsfy.repository.PromocaoRepository;
import lombok.Data;

@Data
public class ProdutoPromocaoForm {

	private Long promocao_id;

	public Produto atualizar(Long id, ProdutoRepository produtoRepository,
							 PromocaoRepository promocaoRepository) {

		if(this.promocao_id == null){
			Produto produto = produtoRepository.getById(id);
			produto.setPromocao(null);

			return produto;
		}
		Produto produto = produtoRepository.getById(id);
		Promocao promocao = promocaoRepository.getById(this.promocao_id);
		produto.setPromocao(promocao);
		
		return produto;
	}
}
