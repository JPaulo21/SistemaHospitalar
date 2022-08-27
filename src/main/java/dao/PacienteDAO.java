package dao;

import java.util.ArrayList;
import java.util.List;

import model.Paciente;

public class PacienteDAO {
	
	private static List<Paciente> pacientes;
	
	private static PacienteDAO pacienteDAO;
	
	public static PacienteDAO getInstance() {
		if(pacienteDAO == null) {
			pacienteDAO = new PacienteDAO();
			pacientes = new ArrayList<Paciente>();

//			Paciente p0 = new Paciente("123.132.123-43", "Pedro Henrique");
//			pacientes.add(p0);
//			
//			Paciente p1 = new Paciente("654.451.376-27", "Ana Maria");
//			pacientes.add(p1);
//			
//			Paciente p2 = new Paciente("342.009.876-91", "Beatriz Ribeiro");
//			pacientes.add(p2);
		}		
		
		return pacienteDAO;
	}
	
	public List<Paciente> pacientes(){
		
		return pacientes;
	}
	
	public void removerPaciente(Paciente p) {
		
		pacientes.remove(p);
	}
	
	public void cadastrar(Paciente p) {
		
		pacientes.add(p);
	}

}
