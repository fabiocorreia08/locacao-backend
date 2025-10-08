package br.com.locacao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.locacao.dto.LocatarioDTO;
import br.com.locacao.service.LocatarioService;

@RestController
@RequestMapping("/api/locatarios")
public class LocatarioController {

	@Autowired
	private LocatarioService service;
	
	@GetMapping("/filtrar")
    public Page<LocatarioDTO> buscarPaginado(
        @RequestParam(required = false) String nome,
        Pageable pageable
    ) {
        return service.buscarPaginado(nome, pageable);
    }

    @GetMapping("/{id}")
    public LocatarioDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
   
    @GetMapping("/cpf/{cpf}")
    public LocatarioDTO buscarPorCpf(@PathVariable String cpf) {
        return service.buscarPorCpf(cpf);
    }
    
    @PostMapping
    public LocatarioDTO salvar(@RequestBody LocatarioDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public LocatarioDTO atualizar(@PathVariable Long id, @RequestBody LocatarioDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }	
    
   
    
}
