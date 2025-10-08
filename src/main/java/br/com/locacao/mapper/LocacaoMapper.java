package br.com.locacao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.locacao.dto.LocacaoDTO;
import br.com.locacao.entity.Locacao;

@Mapper(componentModel = "spring")
public interface LocacaoMapper {

    @Mappings({
        @Mapping(source = "locatario.id", target = "locatarioId"),
        @Mapping(source = "locatario", target = "locatarioDTO"),
        @Mapping(source = "locador.id", target = "locadorId"),
        @Mapping(source = "locador", target = "locadorDTO"),
        @Mapping(source = "imovel.id", target = "imovelId"),
        @Mapping(source = "imovel", target = "imovelDTO")
    })
    LocacaoDTO toDTO(Locacao entity);

    @Mappings({
        @Mapping(target = "locatario.id", source = "locatarioId"),
        @Mapping(target = "locador.id", source = "locadorId"),
        @Mapping(target = "imovel.id", source = "imovelId")
    })
    Locacao toEntity(LocacaoDTO dto);
}