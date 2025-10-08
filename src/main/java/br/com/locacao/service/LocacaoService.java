package br.com.locacao.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.locacao.dto.LocacaoDTO;
import br.com.locacao.entity.Imovel;
import br.com.locacao.entity.Locacao;
import br.com.locacao.entity.Locador;
import br.com.locacao.entity.Locatario;
import br.com.locacao.mapper.LocacaoMapper;
import br.com.locacao.repository.ImovelRepository;
import br.com.locacao.repository.LocacaoRepository;
import br.com.locacao.repository.LocadorRepository;
import br.com.locacao.repository.LocatarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocacaoService {

	@Autowired
    private LocacaoRepository repository;
	
	@Autowired
    private LocadorRepository locadorRepository;
	
	@Autowired
    private LocatarioRepository locatarioRepository;
	
	@Autowired
    private ImovelRepository imovelRepository;
	
	@Autowired
    private LocacaoMapper mapper;

    public List<LocacaoDTO> buscarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
    
	public Page<LocacaoDTO> buscarPaginado(String nomeLocatario, LocalDate dataInicio, Pageable pageable) {
	    Page<Locacao> page;

	    boolean temNome = nomeLocatario != null && !nomeLocatario.trim().isEmpty();
	    boolean temData = dataInicio != null;

	    if (temNome && temData) {
	        page = repository.findByLocatario_NomeContainingIgnoreCaseAndDataInicio(nomeLocatario, dataInicio, pageable);
	    } else if (temNome) {
	        page = repository.findByLocatario_NomeContainingIgnoreCase(nomeLocatario, pageable);
	    } else if (temData) {
	        page = repository.findByDataInicio(dataInicio, pageable);
	    } else {
	        page = repository.findAll(pageable);
	    }

	    return page.map(mapper::toDTO);
	}

    public LocacaoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Imóvel não encontrado"));
    }
  
    public LocacaoDTO salvar(LocacaoDTO dto) {
    	if (repository.existsByImovelIdAndDataFimGreaterThanEqualAndDataInicioLessThanEqual(
    		    dto.getImovelId(), dto.getDataInicio(), dto.getDataFim())) {
    		  throw new ResponseStatusException(HttpStatus.CONFLICT, "Este imóvel já está reservado nesse período.");
    	}

        Locacao locacao = mapper.toEntity(dto);

        Imovel imovel = imovelRepository.findById(dto.getImovelId())
        	    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imóvel não encontrado"));

       Locador locador = locadorRepository.findById(dto.getLocadorId())
        	    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Locador não encontrado"));

       Locatario locatario = locatarioRepository.findById(dto.getLocatarioId())
        	    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Locatário não encontrado"));
       
       locacao.setImovel(imovel);
       locacao.setLocador(locador);
       locacao.setLocatario(locatario);

       Locacao salvo = repository.save(locacao);
       return mapper.toDTO(salvo);
    }

    public LocacaoDTO atualizar(Long id, LocacaoDTO dto) {
        Locacao existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imóvel não encontrado"));
        dto.setId(id);
        Locacao atualizado = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(atualizado));
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
    
    public List<LocacaoDTO> buscarPorAno(int ano) {
        return repository.buscarPorAno(ano).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public boolean existeConflitoDeDatas(Long imovelId, LocalDate dataInicio, LocalDate dataFim) {
        return repository.existsByImovelIdAndDataFimGreaterThanEqualAndDataInicioLessThanEqual(
            imovelId, dataInicio, dataFim
        );
    }

}