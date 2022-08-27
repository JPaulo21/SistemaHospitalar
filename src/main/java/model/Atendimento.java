package model;

import lombok.Data;

@Data
public class Atendimento {
	
	private int cd_atendime;
	private Medico medico;
	private Paciente paciente;
	private String enfermidade;
	private String diagnostico;
	private String situacao;
	private String descricao;
	private String data;
	
	public Atendimento(int cd_atendime, Medico medico, Paciente paciente, String enfermidade, String diagnostico,
			String situacao, String descricao, String data) {
		super();
		this.cd_atendime = cd_atendime;
		this.medico = medico;
		this.paciente = paciente;
		this.enfermidade = enfermidade;
		this.diagnostico = diagnostico;
		this.situacao = situacao;
		this.descricao = descricao;
		this.data = data;
	}

	public Atendimento() {
		super();
	}
	
	
	
}
