package br.com.locacao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Locador implements Serializable{
	   
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    @Embedded
    private Endereco endereco;

    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    
    @OneToMany(mappedBy = "locador")
    private List<Imovel> imoveis;


    // Getters and setters



}
