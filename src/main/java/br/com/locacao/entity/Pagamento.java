package br.com.locacao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Pagamento implements Serializable{
	   
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    private double valorPago;
    private String metodo;
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "locacao_id")
    private Locacao locacao;

}
