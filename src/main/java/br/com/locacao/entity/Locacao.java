package br.com.locacao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Locacao implements Serializable{
	   
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    private Date dataFim;

    private double valorTotal;
    private int qtdPessoas;
    private String formaPagamento;
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;
    
    @ManyToOne
    @JoinColumn(name = "locatario_id")
    private Locatario locatario;

    @OneToMany(mappedBy = "locacao")
    private List<Pagamento> pagamentos;


}
