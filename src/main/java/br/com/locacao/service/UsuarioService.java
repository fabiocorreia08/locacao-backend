package br.com.locacao.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.locacao.dto.UsuarioDTO;
import br.com.locacao.entity.Usuario;
import br.com.locacao.mapper.UsuarioMapper;
import br.com.locacao.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder, UsuarioMapper mapper) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    public UsuarioDTO salvar(UsuarioDTO dto) {
        Usuario usuario = mapper.toEntity(dto);
        usuario.setPassword(passwordEncoder.encode(dto.getPassword())); // 🔐 Criptografa a senha
        repository.save(usuario);
        return mapper.toDTO(usuario);
    }
}