package br.com.locacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locacao.entity.Locador;

public interface LocadorRepository extends JpaRepository<Locador, Long> {
	
	boolean existsByCpf(String cpf);
}

