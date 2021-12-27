package com.stratwsfy.stratwsfy.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.stratwsfy.stratwsfy.controller.form.ProdutoPromocaoForm;
import com.stratwsfy.stratwsfy.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stratwsfy.stratwsfy.controller.dto.ProdutoDto;
import com.stratwsfy.stratwsfy.controller.form.ProdutoForm;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutosService produtosService;

	
	@GetMapping
	public List<ProdutoDto> listar(String nomeProduto){

		return produtosService.getAll(nomeProduto);
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDto> salvar(@RequestBody @Valid ProdutoForm produtoForm){

		return ResponseEntity.ok(produtosService.save(produtoForm));

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDto> buscar(@PathVariable Long id){

		return produtosService.getById(id);
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizar(@RequestBody ProdutoForm produtoForm, @PathVariable Long id){
		
		return produtosService.edit(produtoForm, id);

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> remover(@PathVariable Long id){

		return produtosService.delete(id);

	}

	@PutMapping("/associarPromocao/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> associarPromocao(
			@RequestBody ProdutoPromocaoForm produtoPromocaoForm, @PathVariable Long id){

		return produtosService.associarPromocao(produtoPromocaoForm, id);
	}

	@PutMapping("/removerPromocao/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> removerPromocao(@PathVariable Long id){

		return produtosService.removerPromocao(id);
	}

	
}
