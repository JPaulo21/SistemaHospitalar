package main;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import dao.AtendimentoDAO;
import dao.CirurgiaDAO;
import dao.LoginDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import view.LoginPanel;

public class Main {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		
		AtendimentoDAO.getInstance();
		MedicoDAO.getInstance();
		CirurgiaDAO.getInstance();
		LoginDAO.getInstance();
		PacienteDAO.getInstance();

		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\joao.almeida\\Documents\\Projeto CUBO\\Java\\eclipse-workspace\\SistemaHospitalar\\src\\main\\resources\\2102641-estetoscopio-icone-medicina-medico-saude-medico-cuidado-hospital-ajuda-simbolo-isolado-simbolo-para-web-e-aplicativo-movel-gr\u00E1tis-vetor.jpg"));
		frame.setSize(1250, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sistema Hospitalar");
		
		JMenuBar menuBar= new JMenuBar();
		
		JMenu itemSobre = new JMenu("Sobre Nós");
		JMenu itemInicio = new JMenu("Início");
		JMenu itemConfig = new JMenu("Configuração");
		
		
		menuBar.add(itemInicio);
		menuBar.add(itemConfig);
		menuBar.add(itemSobre);
		

		frame.setJMenuBar(menuBar);
		
		frame.setContentPane(new LoginPanel());
	}
	
	public static JFrame getFrame() {
		return frame;
	}

}
