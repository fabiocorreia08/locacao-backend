package br.com.locacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.locacao.entity.Imovel;
import br.com.locacao.repository.ImovelRepository;

@Service
public class ImovelService {

    private final ImovelRepository repository;

    public ImovelService(ImovelRepository repository) {
        this.repository = repository;
    }

    public List<Imovel> listarTodos() {
        return repository.findAll();
    }

    public Optional<Imovel> buscarPorId(int id) {
        return repository.findById(id);
    }

    public Imovel salvar(Imovel Imovel) {
        return repository.save(Imovel);
    }

    public Imovel atualizar(int id, Imovel novo) {
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
