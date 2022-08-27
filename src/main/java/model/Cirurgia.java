package model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cirurgia extends Atendimento{
	
	private String procedimento;
	private String dataCirurgia;
	private String observacao;
	private List<String> ferramentas;
	private List<Enfermeiro> enfermeiros;
	
	public Cirurgia() {
		super();
		this.ferramentas = new ArrayList<>();
		this.enfermeiros = new ArrayList<Enfermeiro>();
		
	}
	
	
	
}
