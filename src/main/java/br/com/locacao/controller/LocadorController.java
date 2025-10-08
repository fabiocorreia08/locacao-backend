package br.com.locacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.locacao.dto.LocadorDTO;
import br.com.locacao.service.LocadorService;

@RestController
@RequestMapping("/api/locadores")
public class LocadorController {
	
	@Autowired
	private LocadorService service;

	@GetMapping
    public List<LocadorDTO> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public LocadorDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public LocadorDTO salvar(@RequestBody LocadorDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public LocadorDTO atualizar(@PathVariable Long id, @RequestBody LocadorDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }	

}
