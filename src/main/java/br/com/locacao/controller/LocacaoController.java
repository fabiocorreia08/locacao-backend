package br.com.locacao.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.locacao.dto.LocacaoDTO;
import br.com.locacao.service.LocacaoService;

@RestController
@RequestMapping("/api/locacoes")
public class LocacaoController {
	
	@Autowired
	private LocacaoService service;

	@GetMapping
    public List<LocacaoDTO> buscarTodos() {
        return service.buscarTodos();
    }
	
	@GetMapping("/filtrar")
    public Page<LocacaoDTO> buscarPaginado(
        @RequestParam(required = false) String nomeLocacao,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
        Pageable pageable
    ) {
        return service.buscarPaginado(nomeLocacao, dataInicio, pageable);
    }

    @GetMapping("/{id}")
    public LocacaoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
  
    @PostMapping
    public LocacaoDTO salvar(@RequestBody LocacaoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public LocacaoDTO atualizar(@PathVariable Long id, @RequestBody LocacaoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
    
    @GetMapping("/intervalos")
    public List<LocacaoDTO> buscarIntervalosPorAno(@RequestParam int ano) {
        return service.buscarPorAno(ano);
    }

}
