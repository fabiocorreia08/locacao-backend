package br.com.locacao.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Locacao {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private LocalDate dataInicio;
    
    private LocalDate dataFim;
    
    private int qtdDias;
    private int qtdPessoas;
    private Double valorDiaria;    
    
    private Double valorLocacao;
    private Double valorFaxina;
    
    private Double valorTotal;    
    
    private Double valorReserva;    
    private Double valorRestante;    
    
    private LocalDate dataReserva;    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locador_id")
    private Locador locador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locatario_id")
    private Locatario locatario;


    //@OneToMany(mappedBy = "locacao")
    //private List<Pagamento> pagamentos;

}
