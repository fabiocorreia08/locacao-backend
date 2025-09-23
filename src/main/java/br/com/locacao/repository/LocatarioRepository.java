package br.com.locacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locacao.entity.Locatario;

public interface LocatarioRepository extends JpaRepository<Locatario, Integer> {
}

