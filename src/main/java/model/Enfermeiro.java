package model;

import lombok.Data;

@Data
public class Enfermeiro {
	
	private String coren;
	private String nome;
	private String especialidade;
	private String crm;
	
	public Enfermeiro(String coren, String nome, String especialidade, String crm) {
		super();
		this.coren = coren;
		this.nome = nome;
		this.especialidade = especialidade;
		this.crm = crm;
	}

}
