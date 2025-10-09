package br.com.locacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.locacao.entity.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
