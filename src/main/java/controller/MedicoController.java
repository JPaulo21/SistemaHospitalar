package controller;

import dao.LoginDAO;
import dao.MedicoDAO;
import model.Medico;

public class MedicoController {
	
	public boolean estaValido(Medico m) throws Exception{

		if (m.getNome().trim().isEmpty()) {
			throw new Exception("Nome n�o informado");
			
		} else if(m.getCrm().trim().isEmpty() && m.getCrm().length() < 6) {
			throw new Exception("CRM inv�lido ou n�o informado");
			
		} else if(m.getSenha().trim().isEmpty()) {
			throw new Exception("Senha n�o informada");
			
		} else if(m.getEspecialidade().trim().isEmpty()) {
			throw new Exception("Especialidade n�o informada");
			
		} else {
			return true;
		}
		
		
	}
	
	public void cadastrar(Medico m) throws Exception{
		
		if(estaValido(m))
			MedicoDAO.cadastrar(m);
			LoginDAO.getInstance().cadastrarLogin(m);
		
		
	}
	
	public Medico buscarPorCRMeUF(String crm, String uf) throws Exception{
		
		Medico m = MedicoDAO.buscarMedico(crm, uf);
		
		if(m == null) {
			throw new Exception("Registro do m�dico n�o encontrado");
			
		} else {
			
			return m;
		}
					
	}

}
