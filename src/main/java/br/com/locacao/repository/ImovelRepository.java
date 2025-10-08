package br.com.locacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locacao.entity.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
