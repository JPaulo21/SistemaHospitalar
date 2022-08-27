package dao;

import java.util.ArrayList;
import java.util.List;

import model.Cirurgia;
import model.Enfermeiro;
import model.Medico;
import model.Paciente;

public class CirurgiaDAO {

	private static List<Cirurgia> cirurgias;

	private static CirurgiaDAO cirurgiaDAO;

	public static CirurgiaDAO getInstance() {
		if (cirurgiaDAO == null) {
			cirurgiaDAO = new CirurgiaDAO();
			cirurgias = new ArrayList<Cirurgia>();

			Medico m = new Medico("123456", "PE", "João", "123", "Clínico Geral");
			Cirurgia c = new Cirurgia();

			c.setMedico(m);
			c.setPaciente(new Paciente("123.132.123-43", "Megan Rapinoe"));
			c.setCd_atendime(10);
			c.setEnfermidade("Dor no miocárdio");
			c.setDiagnostico("1 Comprimido a cada 6 hrs");
			c.setSituacao("Cirurgia");
			c.setDescricao("Fortes dores no peito, dificuldade pra respirar");
			c.setData("22/08/2019");
			c.setDataCirurgia("25/12/2019");
			c.setProcedimento("Implante de desfripilador");
			c.setObservacao("Cuidado máximo ao realizar anestesia, cirurgia de longa duração");
			c.getEnfermeiros().add(new Enfermeiro("COREN-SP 12432", "Lourdes", "Auxiliar de Cirurgia", m.getCrm()));
			c.getEnfermeiros().add(new Enfermeiro("COREN-AL 89423", "Mônica", "Triagem", m.getCrm()));
			c.getEnfermeiros().add(new Enfermeiro("COREN-CE 54242", "Breno", "Anestesia", m.getCrm()));
			c.getFerramentas().add("Bisturi");
			c.getFerramentas().add("Pinça");
			c.getFerramentas().add("Agulha");

			cirurgias.add(c);

			// ---------------------------------------------------

			Cirurgia a1 = new Cirurgia();

			a1.setMedico(m);
			a1.setPaciente(new Paciente("500.158.200-84", "Marta"));
			a1.setCd_atendime(21);
			a1.setEnfermidade("Gripe");
			a1.setDiagnostico("Dipirona a cada 2hrs");
			a1.setSituacao("Cirurgia");
			a1.setDescricao("Espirando bastante e irritação no nariz");
			a1.setData("13/04/2021");
			a1.setDataCirurgia("25/12/2019");
			a1.setProcedimento("Remoção de tumor");
			a1.setObservacao("Tumor alojado na parte esquerda do miocárdio");
			a1.getEnfermeiros().add(new Enfermeiro("COREN-SP 12432", "Lourdes", "Auxiliar de Cirurgia", m.getCrm()));
			a1.getEnfermeiros().add(new Enfermeiro("COREN-CE 23454", "Paulo", "Cuidadora de idosos", m.getCrm()));
			a1.getEnfermeiros().add(new Enfermeiro("COREN-CE 54242", "Breno", "Anestesia", m.getCrm()));
			a1.getFerramentas().add("Bisturi");
			a1.getFerramentas().add("Pinça");
			a1.getFerramentas().add("Agulha");

			cirurgias.add(a1);

			// ---------------------------------------------------

			Cirurgia a2 = new Cirurgia();

			a2.setMedico(m);
			a2.setPaciente(new Paciente("606.130.990-28", "Havertz"));
			a2.setCd_atendime(11);
			a2.setEnfermidade("tumor no miocárdio");
			a2.setDiagnostico("Cirurgia");
			a2.setSituacao("Cirurgia");
			a2.setDescricao("Cancêr em rápida evolução");
			a2.setData("15/04/2021");
			a2.setDataCirurgia("23/06/2021");
			a2.setProcedimento("Troca da Válvula Cardíaca");
			a2.setObservacao("Cuidado máximo ao realizar anestesia, cirurgia de longa duração");

			cirurgias.add(a2);

			// -------------------------------------------------------
			Cirurgia a3 = new Cirurgia();

			a3.setMedico(m);
			Paciente p1 = new Paciente("434.555.500-02", "Salah");
			a3.setPaciente(p1);
			a3.setCd_atendime(72);
			a3.setEnfermidade("COVID-19");
			a3.setDiagnostico("Vacina");
			a3.setSituacao("Cirurgia(a)");
			a3.setDescricao("Cancêr em rápida evolução");
			a3.setData("30/06/2021;");
			a3.setDataCirurgia("12/07/2021");
			a3.setProcedimento("Cirurgia Cardíaca Minimamente Invasiva");
			a3.setObservacao("Anestesia deve ser feito a cada 2hrs, cirurgia de longa duração, deve ser realizada cuidadosamente");

			cirurgias.add(a3);

			// -------------------------------------------------------

			Cirurgia a4 = new Cirurgia();

			a4.setMedico(m);
			Paciente p2 = new Paciente("342.009.876-91", "Camavinga");
			a4.setPaciente(p2);
			a4.setCd_atendime(38);
			a4.setEnfermidade("Aritmia");
			a4.setDiagnostico("medicamento");
			a4.setSituacao("Cirurgia");
			a4.setData("18/02/2018");
			a4.setDataCirurgia("01/03/2018");
			a4.setProcedimento("Substituição do miocárdio");
			a4.setObservacao("Transplante de coração, requer cautela e mãos firmes para aplicar o corte e custurar.");

			cirurgias.add(a4);

			// ---------------------------------------------------------

		}

		return cirurgiaDAO;
	}

	public List<Cirurgia> todasCirurgias() {

		return cirurgias;
	}

	public List<Cirurgia> cirurgiasPorCRM(String crm) {

		List<Cirurgia> cirurgiasCRM = new ArrayList<Cirurgia>();

		for (Cirurgia c : cirurgias) {

			if (c.getMedico().getCrm().equals(crm))
				cirurgiasCRM.add(c);

		}

		return cirurgiasCRM;
	}

	public Cirurgia cirurgiasPorAtendimento(int cd_atendime) throws Exception{

		Cirurgia cirurgiaAtendime = null;
		
		for (Cirurgia c : cirurgias) {

			if (c.getCd_atendime() == cd_atendime) {
				cirurgiaAtendime = c;
			} 

		}
		
		if(cirurgiaAtendime == null)
			throw new Exception("Selecione uma cirurgia");

		return cirurgiaAtendime;
	}

}
