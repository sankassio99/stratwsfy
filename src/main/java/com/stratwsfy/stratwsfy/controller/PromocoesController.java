package com.stratwsfy.stratwsfy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stratwsfy.stratwsfy.controller.dto.PromocaoDto;
import com.stratwsfy.stratwsfy.model.entity.Promocao;
import com.stratwsfy.stratwsfy.repository.PromocaoRepository;


@RestController
@RequestMapping("/promocoes")
public class PromocoesController {
	
	@Autowired
	private PromocaoRepository promocaoRepository ;
	
	@GetMapping
	public List<PromocaoDto> listar(String nomePromocao){

		List<Promocao> promocoes;
		if(nomePromocao == null) {
			promocoes = promocaoRepository.findAll();
		} else {
			promocoes = promocaoRepository.getByNome(nomePromocao);
		}
		return PromocaoDto.converter(promocoes);

	}

}
