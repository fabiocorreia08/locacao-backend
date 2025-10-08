package br.com.locacao.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.locacao.dto.LocadorDTO;
import br.com.locacao.entity.Locador;
import br.com.locacao.mapper.LocadorMapper;
import br.com.locacao.repository.LocadorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocadorService {

	@Autowired
    private LocadorRepository repository;
	
	@Autowired
    private LocadorMapper mapper;

    public List<LocadorDTO> buscarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public LocadorDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Imóvel não encontrado"));
    }

    public LocadorDTO salvar(LocadorDTO dto) {
    	if (repository.existsByCpf(dto.getCpf())) {
            throw new RuntimeException("CPF já cadastrado.");
        }
        Locador imovel = mapper.toEntity(dto);
        Locador salvo = repository.save(imovel);
        return mapper.toDTO(salvo);
    }

    public LocadorDTO atualizar(Long id, LocadorDTO dto) {
    	
        Locador existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imóvel não encontrado"));
        dto.setId(id);
        Locador atualizado = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(atualizado));
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

}
