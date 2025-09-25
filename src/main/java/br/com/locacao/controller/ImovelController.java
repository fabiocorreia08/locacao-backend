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

import br.com.locacao.entity.Imovel;
import br.com.locacao.service.ImovelService;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {
	
	private final ImovelService service;

    public ImovelController(ImovelService service) {
        this.service = service;
    }

    @GetMapping
    public List<Imovel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> buscarPorId(@PathVariable int id) {
        return service.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Imovel salvar(@RequestBody Imovel imovel) {
        return service.salvar(imovel);
    }

    @PutMapping("/{id}")
    public Imovel atualizar(@PathVariable int id, @RequestBody Imovel imovel) {
        return service.atualizar(id, imovel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
