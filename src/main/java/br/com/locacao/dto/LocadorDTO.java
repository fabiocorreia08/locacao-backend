package br.com.locacao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocadorDTO {

	 private Long id;
	 private String nome;
	 private String cpf;
	 private String telefone;
	 private String email;
	 
	 private EnderecoDTO endereco;
    
}
