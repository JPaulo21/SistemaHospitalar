package model;

import lombok.Data;

@Data
public class Paciente {
	
	private String cpf;
	private String nome;
	
	public Paciente() {
		
	}
	
	public Paciente(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}
	
	

}
