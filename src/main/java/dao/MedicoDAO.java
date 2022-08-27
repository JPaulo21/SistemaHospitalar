package dao;

import java.util.ArrayList;
import java.util.List;

import model.Medico;

public class MedicoDAO {

	private static MedicoDAO medicoDAO;

	private static List<Medico> medicos;
	// metodos que acessam o objeto(atributo) static devem ser static

	public static MedicoDAO getInstance() {
		if (medicoDAO == null) {
			medicoDAO = new MedicoDAO();
			medicos = new ArrayList<Medico>();

			medicos.add(new Medico("123456", "PE", "Emanoel", "123", "Cardiologista"));

		}
		return medicoDAO;
	}

	public static Medico buscarMedico(String crm, String uf) throws Exception {

		Medico medico = null;

		for (Medico m : medicos) {

			if (m.getCrm().equals(crm) && m.getUf().equals(uf)) {

				medico = m;
			}
		}

		return medico;
	}

	public static void cadastrar(Medico m) {

		medicos.add(m);
	}

	public static void exibirMedicos() {

		for (Medico m : medicos)
			System.out.println(m.getNome());
	}

	public static Medico medicoJoao() {

		Medico medico = new Medico();
		
		medico.setCrm("000000");
		
		return medico;
	}

}
