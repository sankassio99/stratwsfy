package com.stratwsfy.stratwsfy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stratwsfy.stratwsfy.model.entity.Promocao;

import java.util.List;

public interface PromocaoRepository extends JpaRepository<Promocao, Long> {


    List<Promocao> getByNome(String nomePromocao);
}
