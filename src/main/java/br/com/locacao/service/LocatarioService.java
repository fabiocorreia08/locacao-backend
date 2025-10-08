package br.com.locacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.locacao.dto.LocatarioDTO;
import br.com.locacao.entity.Locatario;
import br.com.locacao.mapper.LocatarioMapper;
import br.com.locacao.repository.LocatarioRepository;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class LocatarioService {

	@Autowired
    private LocatarioRepository repository;
	
	@Autowired
    private LocatarioMapper mapper;

    //public List<LocatarioDTO> buscarTodos() {
    //    return repository.findAll().stream()
    //            .map(mapper::toDTO)
    //            .collect(Collectors.toList());
    ///}
    
	public Page<LocatarioDTO> buscarPaginado(String nome, Pageable pageable) {
	    Page<Locatario> page = repository.findByNomeContainingIgnoreCase(nome == null ? "" : nome, pageable);
	    return page.map(mapper::toDTO);
	}

    public LocatarioDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Imóvel não encontrado"));
    }
 
    public LocatarioDTO buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf)
            .map(mapper::toDTO)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Locatário não encontrado"));
    }
  
    public LocatarioDTO salvar(LocatarioDTO dto) {
    	if (repository.existsByCpf(dto.getCpf())) {
            throw new RuntimeException("CPF já cadastrado.");
        }

        Locatario imovel = mapper.toEntity(dto);
        Locatario salvo = repository.save(imovel);
        return mapper.toDTO(salvo);
    }

    public LocatarioDTO atualizar(Long id, LocatarioDTO dto) {
    	
        Locatario existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imóvel não encontrado"));
        dto.setId(id);
        Locatario atualizado = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(atualizado));
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

}
