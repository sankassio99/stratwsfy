package com.stratwsfy.stratwsfy.model.entity;

import java.util.List;

import javax.persistence.*;

import com.stratwsfy.stratwsfy.model.TiposPromocao;
import com.stratwsfy.stratwsfy.model.entity.Produto;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;


@Getter
@Setter
@Entity
public class Promocao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String calculo;
	private double x;
	private double y;
	@Enumerated
	private TiposPromocao tipoPromocao ;

	@OneToMany(mappedBy = "promocao")
	private List<Produto> produtos;

	public Promocao() {
	}

	public double aplicarPromocao(int quantidade, double total){

		double calculo = total ;
		double precoUnitario = total/quantidade ;
		int qtdPromocoes = (int) (quantidade / this.x);
		double qtdProdutosaMais = ((quantidade / this.x) - qtdPromocoes ) * this.x;

		if(this.tipoPromocao.equals(TiposPromocao.LEVXPAGY)){
			if(quantidade >= this.x){
				calculo = qtdPromocoes * precoUnitario;
				calculo = calculo + (qtdProdutosaMais * precoUnitario);
			}
		} else if(this.tipoPromocao.equals(TiposPromocao.LEVXPORY)){
			if(quantidade >= this.x){
				calculo = qtdPromocoes * this.y;
				calculo = calculo + (qtdProdutosaMais * precoUnitario);
			}
		}

		return calculo ;
	}
}
