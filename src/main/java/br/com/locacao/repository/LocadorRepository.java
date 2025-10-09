package br.com.locacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.locacao.entity.Locador;

@Repository
public interface LocadorRepository extends JpaRepository<Locador, Long> {
	
	boolean existsByCpf(String cpf);
}

