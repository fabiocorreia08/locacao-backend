package br.com.locacao.mapper;

import org.mapstruct.Mapper;

import br.com.locacao.dto.LocadorDTO;
import br.com.locacao.entity.Locador;

@Mapper(componentModel = "spring")
public interface LocadorMapper {
    LocadorDTO toDTO(Locador locador);
    Locador toEntity(LocadorDTO dto);
}
