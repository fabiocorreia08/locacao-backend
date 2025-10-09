package br.com.locacao.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.locacao.entity.Locacao;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

	@EntityGraph(attributePaths = {"locatario"})
	Page<Locacao> findByLocatario_NomeContainingIgnoreCase(String nomeLocatario, Pageable pageable);

	@EntityGraph(attributePaths = {"locatario"})
	Page<Locacao> findByDataInicio(LocalDate dataInicio, Pageable pageable);

	@EntityGraph(attributePaths = {"locatario"})
	Page<Locacao> findByLocatario_NomeContainingIgnoreCaseAndDataInicio(String nomeLocatario, LocalDate dataInicio, Pageable pageable);

	@EntityGraph(attributePaths = {"locador", "locatario", "imovel"})
	Page<Locacao> findAll(Pageable pageable);
	
	@Query("SELECT l FROM Locacao l WHERE YEAR(l.dataInicio) = :ano OR YEAR(l.dataFim) = :ano")
	List<Locacao> buscarPorAno(@org.springframework.data.repository.query.Param("ano") int ano);
	
	boolean existsByImovelIdAndDataFimGreaterThanEqualAndDataInicioLessThanEqual(
		    Long imovelId, LocalDate dataInicio, LocalDate dataFim
	);
}
