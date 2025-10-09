package br.com.locacao.mapper;

import org.mapstruct.Mapper;

import br.com.locacao.dto.UsuarioDTO;
import br.com.locacao.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioDTO toDTO(Usuario usuario);
    Usuario toEntity(UsuarioDTO dto);
}