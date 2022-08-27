package model;

import lombok.Data;

@Data
public class Medico {

	private String crm;
	private String uf;
	private String nome;
	private String senha;
	private String especialidade;
	
	public Medico() {
		
	}
	
	public Medico(String crm, String uf, String nome, String senha, String especialidade) {
		this.crm = crm;
		this.uf = uf;
		this.nome = nome;
		this.senha = senha;
		this.especialidade = especialidade;
	}


	
	
}
