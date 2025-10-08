package br.com.locacao.mapper;

import org.mapstruct.Mapper;

import br.com.locacao.dto.LocatarioDTO;
import br.com.locacao.entity.Locatario;

@Mapper(componentModel = "spring")
public interface LocatarioMapper {
    LocatarioDTO toDTO(Locatario locatario);
    Locatario toEntity(LocatarioDTO dto);
}
