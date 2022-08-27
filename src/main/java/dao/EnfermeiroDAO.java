package dao;

import java.util.ArrayList;
import java.util.List;

import model.Enfermeiro;

public class EnfermeiroDAO {
	
	private static EnfermeiroDAO enfermeiroDAO;
	
	private static List<Enfermeiro> enfermeiros;
	
	public static EnfermeiroDAO getInstance() {
		if(enfermeiroDAO == null){
			enfermeiroDAO = new EnfermeiroDAO();
			enfermeiros = new ArrayList<Enfermeiro>();
			
		}
		
		enfermeiros.add(new Enfermeiro("COREN-SP 12432", "Lourdes", "Auxiliar de Cirurgia", "123456"));
		enfermeiros.add(new Enfermeiro("COREN-AL 89423", "Mônica", "Triagem", "000000"));
		enfermeiros.add(new Enfermeiro("COREN-CE 54242", "Breno", "Anestesia", "123456"));
		enfermeiros.add(new Enfermeiro("COREN-CE 23454", "Paulo", "Cuidadora de idosos", "123456"));
		enfermeiros.add(new Enfermeiro("COREN-CE 09423", "Nayara", "Administrativa", "123456"));
		enfermeiros.add(new Enfermeiro("COREN-CE 76892", "Jade", "Suprimentos", "123456"));
		
		return enfermeiroDAO;
	}
	
	public List<Enfermeiro> todosEnfermeiros(){
		
		return enfermeiros;
	}
	
	public List<Enfermeiro> buscarEnfermeiroPorCRM(String crm){
		
		List<Enfermeiro> enfs = new ArrayList<Enfermeiro>();
		
		for(Enfermeiro e:enfermeiros) {
			
			if(e.getCrm().equals(crm))
				enfs.add(e);
				
		}
		
		return enfs;
	}

}
