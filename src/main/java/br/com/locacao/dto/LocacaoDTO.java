package br.com.locacao.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocacaoDTO {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFim;

    private Integer qtdDias;
    private Integer qtdPessoas;   
    private Double valorDiaria;
    
    private Double valorLocacao;
    private Double valorFaxina;
    
    private Double valorTotal;    
       
    private Double valorReserva;   
    private Double valorRestante;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataReserva; 
    
    // IDs para operações de entrada
    private Long imovelId;
    private Long locadorId;
    private Long locatarioId;

    // Objetos para exibição
    private ImovelDTO imovelDTO;
    private LocadorDTO locadorDTO;
    private LocatarioDTO locatarioDTO;
}