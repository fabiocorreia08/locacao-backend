package br.com.locacao.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.locacao.entity.Locatario;

@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, Long> {
	
	Page<Locatario> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

	Optional<Locatario> findByCpf(String cpf);
	
	boolean existsByCpf(String cpf);
	
}

