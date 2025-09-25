package br.com.locacao.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Imovel implements Serializable{
	   
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tipo;    
    private String descricao;
    
    @Embedded
    private Endereco endereco;
   
    @ManyToOne
    @JoinColumn(name = "locador_id")
    private Locador locador;
    
    @OneToMany(mappedBy = "imovel")
    private List<Locacao> locacoes;
    
}
