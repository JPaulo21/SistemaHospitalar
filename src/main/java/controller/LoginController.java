package controller;

import dao.LoginDAO;
import model.Login;

public class LoginController {
	

	private boolean validarDados(Login l) throws Exception {
		
		if (l.getCrm().trim().isEmpty()) {
			throw new Exception("CRM não informado!");
			
		} else if (l.getSenha().trim().isEmpty()) {
			throw new Exception("Senha não informada!");			
			
		} else if (l.getUf().equals("")){
			System.out.println(l.getUf());
			throw new Exception("UF não informado!");
			
		} else {	
			return true;
			
		}
		
	}
	
	public boolean logar(Login l) throws Exception {

			
		if(validarDados(l)) {
			
			Login login = LoginDAO.getInstance().burcarLogin(l.getCrm());

			if(l.getCrm().equals(login.getCrm()) 
			&& l.getSenha().equals(login.getSenha()) 
			&& l.getUf().equals(login.getUf()) ) {
				
				return true;
			} else if ( l.getSenha() != login.getSenha() 
					&& l.getUf().equals(login.getUf())){
				
				throw new Exception("Usuário ou Senha Inválido");
			} else {
				
				throw new Exception("Registro não encontrado");
			}
			
		} else {
			
			throw new Exception("Registro não encontrado");
		}
	}
	
	
	
	
}
