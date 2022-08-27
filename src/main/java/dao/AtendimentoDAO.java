package dao;

import java.util.ArrayList;
import java.util.List;

import model.Atendimento;
import model.Medico;
import model.Paciente;

public class AtendimentoDAO {

	private static List<Atendimento> atendimentos;

	private static AtendimentoDAO a;

	public static AtendimentoDAO getInstance() {
		if (atendimentos == null) {
			atendimentos = new ArrayList<Atendimento>();
			a = new AtendimentoDAO();

			Atendimento a = new Atendimento();

			a.setMedico(new Medico("123456", "PE", "Emanoel", "123456", "Cardiologista"));
			a.setPaciente(new Paciente("123.132.123-43", "Pedro Henrique"));
			a.setCd_atendime(0);
			a.setEnfermidade("Dor no miocárdio");
			a.setDiagnostico("1 Comprimido a cada 6 hrs");
			a.setSituacao("Crítica");
			a.setDescricao("Fortes dores no peito, dificuldade pra respirar");
			a.setData("22/08/2019");

			atendimentos.add(a);

			// ---------------------------------------------------
			
			Atendimento a1 = new Atendimento();
			
			a1.setMedico(new Medico("123456", "PE", "Emanoel", "123456", "Cardiologista"));
			a1.setPaciente(new Paciente("123.132.123-43", "Pedro Henrique"));
			a1.setCd_atendime(421);
			a1.setEnfermidade("Gripe");
			a1.setDiagnostico("Dipirona a cada 2hrs");
			a1.setSituacao("Liberado(a)");
			a1.setDescricao("Espirando bastante e irritação no nariz");
			a1.setData("13/04/2021");

			atendimentos.add(a1);

			// ---------------------------------------------------

			Atendimento a2 = new Atendimento();

			a2.setMedico(new Medico("123456", "PE", "Emanoel", "123456", "Cardiologista"));
			a2.setPaciente(new Paciente("654.451.376-27", "Ana Maria"));
			a2.setCd_atendime(1);
			a2.setEnfermidade("tumor no miocárdio");
			a2.setDiagnostico("Cirurgia");
			a2.setSituacao("Instável");
			a2.setDescricao("Cancêr em rápida evolução");
			a2.setData("22/08/2019");

			atendimentos.add(a2);

			// -------------------------------------------------------
			Atendimento a3 = new Atendimento();

			a3.setMedico(new Medico("123456", "PE", "Emanoel", "123456", "Cardiologista"));
			Paciente p1 = new Paciente("654.451.376-27", "Ana Maria");
			a3.setPaciente(p1);
			a3.setCd_atendime(7);
			a3.setEnfermidade("COVID-19");
			a3.setDiagnostico("Vacina");
			a3.setSituacao("Liberado(a)");
			a3.setDescricao("Cancêr em rápida evolução");
			a3.setData("14/01/2019");

			atendimentos.add(a3);

			// -------------------------------------------------------

			Atendimento a4 = new Atendimento();

			a4.setMedico(new Medico("123456", "PE", "Emanoel", "123456", "Cardiologista"));
			Paciente p2 = new Paciente("342.009.876-91", "Beatriz Ribeiro");
			a4.setPaciente(p2);
			a4.setCd_atendime(2);
			a4.setEnfermidade("Aritmia");
			a4.setDiagnostico("medicamento");
			a4.setSituacao("Estável");
			a4.setData("22/08/2019");

			atendimentos.add(a4);

			// ---------------------------------------------------------

		}

		return a;

	}

	public List<Atendimento> pacientesEmAtendimento(String crm) {

		List<Atendimento> atendimes = new ArrayList<Atendimento>();

		for (Atendimento a : atendimentos) {

			if (a.getMedico().getCrm().equals(crm) && !a.getSituacao().equalsIgnoreCase("liberado(a)"))
				atendimes.add(a);
		}

		return atendimes;
	}
	
	public List<Atendimento> buscarAtendimentoPorCPF(String cpf) {

		List<Atendimento> atendimes = new ArrayList<Atendimento>();

		for (Atendimento a : atendimentos) {

			if (a.getPaciente().getCpf().equals(cpf))
				atendimes.add(a);
		}

		return atendimes;
	}
	
	public List<Atendimento> buscarAtendimentoPorCPFeCRM(String cpf, String crm) {

		List<Atendimento> atendimes = new ArrayList<Atendimento>();

		for (Atendimento a : atendimentos) {

			if (a.getPaciente().getCpf().equals(cpf) && a.getMedico().getCrm().equals(crm)) {
				atendimes.add(a);
			}
		}

		return atendimes;
	}

	public Atendimento buscarAtendimentoPorCd_Atendimento(int cd_atendime) throws Exception{

		Atendimento atendimento = null;

		for (Atendimento a : atendimentos) {

			if (a.getCd_atendime() == cd_atendime)
				atendimento = a;
		}

		return atendimento;
	}

	public void cadastrar(Atendimento a) {
		
		atendimentos.add(a);
	}
	
	public List<Atendimento> atendimentos() {
		
		return atendimentos;
	}
	
	public void removerAtendimento(Atendimento a) {
		
		atendimentos.remove(a);
	}
	
	public void atualizarAtendimento(Atendimento a) {
		
		for(Atendimento atendi : atendimentos) {
			
			if(atendi.getCd_atendime() == a.getCd_atendime()) {
				atendi.setData(a.getData());
				atendi.setDescricao(a.getDescricao());
				atendi.setDiagnostico(a.getDiagnostico());
				atendi.setEnfermidade(a.getEnfermidade());
				atendi.setMedico(a.getMedico());
				atendi.setPaciente(a.getPaciente());
				atendi.setSituacao(a.getSituacao());
				
			}
		}
	}
	
}
