package model;

import lombok.Data;

@Data
public class Login {

	private String crm;
	private String uf;
	private String senha;
	
	public Login() {
		
	}	
	
	public Login(String crm, String uf, String senha) {
		super();
		this.crm = crm;
		this.uf = uf;
		this.senha = senha;
	}
}
