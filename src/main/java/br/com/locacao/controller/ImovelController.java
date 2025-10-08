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

import br.com.locacao.dto.ImovelDTO;
import br.com.locacao.service.ImovelService;

@RestController
@RequestMapping("/api/imoveis")
public class ImovelController {
	
	@Autowired
	private ImovelService service;

	@GetMapping
    public List<ImovelDTO> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public ImovelDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ImovelDTO salvar(@RequestBody ImovelDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public ImovelDTO atualizar(@PathVariable Long id, @RequestBody ImovelDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }	

}
