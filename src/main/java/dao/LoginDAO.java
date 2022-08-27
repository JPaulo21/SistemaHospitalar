package dao;

import java.util.ArrayList;
import java.util.List;

import model.Login;
import model.Medico;

public class LoginDAO {
	
	private static LoginDAO loginDAO;
	
	private static List<Login> logins;
	
	public static LoginDAO getInstance() {
		if(loginDAO == null) {
			loginDAO = new LoginDAO();
			logins = new ArrayList<Login>();
			
			Login l = new Login();
			l.setCrm("123456");
			l.setSenha("123");
			l.setUf("PE");
			
			logins.add(l);
		}
		
		return loginDAO;
	}
	
	public Login burcarLogin(String crm) throws Exception{
		
		Login login = new Login();
		
		for(Login log:logins) {
			
			if(log.getCrm().equals(crm)) {
				login = log;
				
			} 		
			
		}
		
		return login;
	}

	public void cadastrarLogin(Medico m) {
		
		logins.add(new Login(m.getCrm(), m.getUf(), m.getSenha()));
		
	}
	
}
