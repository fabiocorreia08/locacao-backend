package br.com.locacao.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.locacao.entity.Locatario;
import br.com.locacao.service.LocatarioService;

@RestController
@RequestMapping("/locatarios")
public class LocatarioController {

    private final LocatarioService service;

    public LocatarioController(LocatarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Locatario> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locatario> buscarPorId(@PathVariable int id) {
        return service.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Locatario criar(@RequestBody Locatario locatario) {
        return service.salvar(locatario);
    }

    @PutMapping("/{id}")
    public Locatario atualizar(@PathVariable int id, @RequestBody Locatario locatario) {
        return service.atualizar(id, locatario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
