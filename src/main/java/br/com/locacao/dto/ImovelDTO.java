package br.com.locacao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImovelDTO {

    private Long id;
    private String tipo;
    private String descricao;
    private EnderecoDTO endereco;
    
}
