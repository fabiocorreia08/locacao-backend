package br.com.locacao.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocatarioDTO {

	 private Long id;
	 private String nome;
	 private String cpf;
	 private String telefone;
	 private String email;
	 @JsonFormat(pattern = "yyyy-MM-dd")
	 private LocalDate dataCadastro;
	 
	 private EnderecoDTO endereco;
    
}
