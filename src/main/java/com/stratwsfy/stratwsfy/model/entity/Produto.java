package com.stratwsfy.stratwsfy.model.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Produto {
		
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private double valor;
	@ManyToOne
	private Promocao promocao;
	
	public Produto(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}


	public Produto(String nome, double valor, Promocao promocao) {
		this.nome = nome;
		this.valor = valor;
		this.promocao = promocao;
	}
}
