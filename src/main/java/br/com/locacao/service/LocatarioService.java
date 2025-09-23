package br.com.locacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.locacao.entity.Locatario;
import br.com.locacao.repository.LocatarioRepository;

@Service
public class LocatarioService {

    private final LocatarioRepository repository;

    public LocatarioService(LocatarioRepository repository) {
        this.repository = repository;
    }

    public List<Locatario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Locatario> buscarPorId(int id) {
        return repository.findById(id);
    }

    public Locatario salvar(Locatario locatario) {
        return repository.save(locatario);
    }

    public Locatario atualizar(int id, Locatario novo) {
        return repository.findById(id)
            .map(loc -> {
                novo.setId(id);
                return repository.save(novo);
            })
            .orElseThrow(() -> new RuntimeException("Locatário não encontrado"));
    }

    public void deletar(int id) {
        repository.deleteById(id);
    }



}
