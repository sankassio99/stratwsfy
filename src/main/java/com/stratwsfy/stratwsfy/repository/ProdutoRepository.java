package com.stratwsfy.stratwsfy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stratwsfy.stratwsfy.model.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> getByNome(String nomeProduto);

}




//
//public interface CursoRepository extends JpaRepository<Curso, Long>{
//
//	Curso findByNome(String nome);
//
//}
