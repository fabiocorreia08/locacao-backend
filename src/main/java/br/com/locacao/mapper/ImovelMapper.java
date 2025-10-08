package br.com.locacao.mapper;

import org.mapstruct.Mapper;
import br.com.locacao.dto.ImovelDTO;
import br.com.locacao.entity.Imovel;

@Mapper(componentModel = "spring")
public interface ImovelMapper {
    ImovelDTO toDTO(Imovel imovel);
    Imovel toEntity(ImovelDTO dto);
}
