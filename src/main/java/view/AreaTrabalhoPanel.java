package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.AtendimentoDAO;
import dao.CirurgiaDAO;
import dao.EnfermeiroDAO;
import main.Main;
import model.Atendimento;
import model.Cirurgia;
import model.Enfermeiro;
import model.Medico;
import model.Paciente;

public class AreaTrabalhoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3214708260678825459L;
	private JTextField txtfBuscarPaciente;
	static JTable table;
	static DefaultTableModel tableModel;
	static DefaultTableModel tableModelCirurgia;
	private List<Atendimento> atendimes;
	private List<Enfermeiro> enfermeiros;
	private int linhaTable;
	private int linhaTableCirurgia;
	private Paciente paciente;
	private JLabel lblMsg;
	static JTable tableAgendaCirurgia;
	private JTextField txtfBuscarCirurgia;
	private List<Cirurgia> cirurgias;
	private Cirurgia cirurgia;
	private JLabel lblMsg3;
	private JTable tableEnfermeiros;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AreaTrabalhoPanel(Medico m) {
		cirurgia = new Cirurgia();
		setBackground(SystemColor.activeCaption);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblIconMed = new JLabel("");
		lblIconMed.setIcon(new ImageIcon(
				"C:\\Users\\joao.almeida\\Documents\\Projeto CUBO\\Java\\eclipse-workspace\\SistemaHospitalar\\src\\main\\resources\\medical-29_icon- 31x31.png"));
		GridBagConstraints gbc_lblIconMed = new GridBagConstraints();
		gbc_lblIconMed.anchor = GridBagConstraints.SOUTH;
		gbc_lblIconMed.insets = new Insets(0, 5, 5, 3);
		gbc_lblIconMed.gridx = 0;
		gbc_lblIconMed.gridy = 0;
		add(lblIconMed, gbc_lblIconMed);

		JLabel lblNewLabel = new JLabel("Olá, " + m.getNome());
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 19));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.insets = new Insets(10, 3, 10, 10);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblSair = new JLabel("<html><u>Sair</u>");
		lblSair.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Main.getFrame().setContentPane(new LoginPanel());
				Main.getFrame().getContentPane().revalidate();
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblSair.setForeground(SystemColor.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblSair.setForeground(SystemColor.BLACK);
			}
		});
		GridBagConstraints gbc_lblSair = new GridBagConstraints();
		gbc_lblSair.insets = new Insets(10, 10, 10, 10);
		gbc_lblSair.gridx = 2;
		gbc_lblSair.gridy = 0;
		add(lblSair, gbc_lblSair);

		JPanel AreaTrabalhoPanel = new JPanel();
		GridBagConstraints gbc_AreaTrabalhoPanel = new GridBagConstraints();
		gbc_AreaTrabalhoPanel.weighty = 1.0;
		gbc_AreaTrabalhoPanel.weightx = 1.0;
		gbc_AreaTrabalhoPanel.gridwidth = 3;
		gbc_AreaTrabalhoPanel.fill = GridBagConstraints.BOTH;
		gbc_AreaTrabalhoPanel.gridx = 0;
		gbc_AreaTrabalhoPanel.gridy = 1;
		add(AreaTrabalhoPanel, gbc_AreaTrabalhoPanel);
		AreaTrabalhoPanel.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPaneGerenciador = new JTabbedPane(JTabbedPane.TOP);
		AreaTrabalhoPanel.add(tabbedPaneGerenciador);

		JPanel panelPacientes = new JPanel();
		panelPacientes.setBorder(
				new TitledBorder(null, "Em atendimento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPaneGerenciador.addTab("Pacientes", null, panelPacientes, null);
		GridBagLayout gbl_panelPacientes = new GridBagLayout();
		gbl_panelPacientes.columnWidths = new int[] { 1047, 0, 0 };
		gbl_panelPacientes.rowHeights = new int[] { 32, 0, 0, 0, 0, 0 };
		gbl_panelPacientes.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelPacientes.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelPacientes.setLayout(gbl_panelPacientes);

		tableModel = new DefaultTableModel();

		tableModel.addColumn("CPF");
		tableModel.addColumn("Paciente");
		tableModel.addColumn("Enfermidade");
		tableModel.addColumn("Diagnostico");
		tableModel.addColumn("Situação");

		atendimes = AtendimentoDAO.getInstance().pacientesEmAtendimento(m.getCrm());
		int i = 0;

		for (Atendimento a : atendimes) {
			Object[] linha = { a.getPaciente().getCpf(), a.getPaciente().getNome(), a.getEnfermidade(),
					a.getDiagnostico(), a.getSituacao() };
			tableModel.insertRow(i++, linha);

		}

		txtfBuscarPaciente = new JTextField();
		txtfBuscarPaciente.setToolTipText("Pesquisa din\u00E2mica, basta digitar o nome do paciente.");
		txtfBuscarPaciente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.setNumRows(0);

				int i = 0;
				
				atendimes = AtendimentoDAO.getInstance().pacientesEmAtendimento(m.getCrm());
				
				for (Atendimento a : atendimes) {

					if (a.getPaciente().getNome().contains(txtfBuscarPaciente.getText())) {
						Object[] linha = { a.getPaciente().getCpf(), a.getPaciente().getNome(), a.getEnfermidade(),
								a.getDiagnostico(), a.getSituacao() };
						tableModel.insertRow(i++, linha);
					}

				}

			}
		});
		GridBagConstraints gbc_txtfBuscarPaciente = new GridBagConstraints();
		gbc_txtfBuscarPaciente.insets = new Insets(5, 3, 5, 5);
		gbc_txtfBuscarPaciente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfBuscarPaciente.gridx = 0;
		gbc_txtfBuscarPaciente.gridy = 0;
		panelPacientes.add(txtfBuscarPaciente, gbc_txtfBuscarPaciente);
		txtfBuscarPaciente.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(2, 5, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panelPacientes.add(scrollPane, gbc_scrollPane);

		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblMsg.setVisible(false);
				
				int linhaTablet;
				linhaTablet = table.getSelectedRow();
				linhaTable = linhaTablet;
				if (linhaTablet > -1) {
					//linhaTable = table.getSelectedRow();
					paciente = new Paciente();
					paciente.setCpf(table.getValueAt(linhaTablet, 0).toString());
					paciente.setNome(table.getValueAt(linhaTablet, 1).toString());
					
				} else {
					linhaTablet = table.getSelectedRow();
					System.out.println("Erro de seleção de JTable\nlinhaTablet: "+linhaTablet);
				}
				
				
				
			}
		});
		scrollPane.setViewportView(table);

		lblMsg = new JLabel();
		lblMsg.setVisible(false);
		
				JButton btnRelatorio = new JButton("Relat\u00F3rio");
				btnRelatorio.setToolTipText("Selecione um paciente primeiro para abrir seu relat\u00F3rio");
				btnRelatorio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try {

							if (linhaTable != -1) {

								RelatorioJFrame r = new RelatorioJFrame(paciente, m);
								r.setVisible(true);

							} else {
								throw new Exception("Paciente não selecionado");

							}

						} catch (Exception e2) {

							e2 = new Exception("Paciente não selecionado");
							lblMsg.setText(e2.getMessage());
							lblMsg.setForeground(SystemColor.RED);
							lblMsg.setVisible(true);
						}
						
						table.clearSelection();

					}
				});
				
				JButton btnNovoPaciente = new JButton("Novo Paciente");
				btnNovoPaciente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						NovoPacienteJFrame novoPaciente = new NovoPacienteJFrame(m);
						novoPaciente.setVisible(true);
						table.clearSelection();
					}
				});
				GridBagConstraints gbc_btnNovoPaciente = new GridBagConstraints();
				gbc_btnNovoPaciente.insets = new Insets(0, 0, 10, 0);
				gbc_btnNovoPaciente.gridx = 1;
				gbc_btnNovoPaciente.gridy = 1;
				panelPacientes.add(btnNovoPaciente, gbc_btnNovoPaciente);
				GridBagConstraints gbc_btnRelatorio = new GridBagConstraints();
				gbc_btnRelatorio.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnRelatorio.insets = new Insets(0, 0, 5, 0);
				gbc_btnRelatorio.gridx = 1;
				gbc_btnRelatorio.gridy = 2;
				panelPacientes.add(btnRelatorio, gbc_btnRelatorio);
		GridBagConstraints gbc_lblMsg = new GridBagConstraints();
		gbc_lblMsg.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMsg.insets = new Insets(0, 0, 5, 0);
		gbc_lblMsg.gridx = 1;
		gbc_lblMsg.gridy = 3;
		panelPacientes.add(lblMsg, gbc_lblMsg);

		JPanel panelListaEnferm = new JPanel();
		panelListaEnferm.setBorder(new TitledBorder(null, "Meus enfermeiros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPaneGerenciador.addTab("Enfermeiros", null, panelListaEnferm, null);
		GridBagLayout gbl_panelListaEnferm = new GridBagLayout();
		gbl_panelListaEnferm.columnWidths = new int[]{0, 0};
		gbl_panelListaEnferm.rowHeights = new int[]{0, 0, 0};
		gbl_panelListaEnferm.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelListaEnferm.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelListaEnferm.setLayout(gbl_panelListaEnferm);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panelListaEnferm.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panelListaEnferm.add(scrollPane_1, gbc_scrollPane_1);
		
		DefaultTableModel tableModelEnf = new DefaultTableModel();

		tableModelEnf.addColumn("COREN");
		tableModelEnf.addColumn("Nome");
		tableModelEnf.addColumn("Especialidde");


		enfermeiros = EnfermeiroDAO.getInstance().buscarEnfermeiroPorCRM(m.getCrm());
		int i2 = 0;

		for (Enfermeiro e : enfermeiros) {
			Object[] linha = { e.getCoren(), e.getNome(), e.getEspecialidade() };
			tableModelEnf.insertRow(i2++, linha);

		}
		
		tableEnfermeiros = new JTable(tableModelEnf);
		scrollPane_1.setViewportView(tableEnfermeiros);

		JPanel panelAgendaCirurgica = new JPanel();
		panelAgendaCirurgica.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Cirurgias",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		tabbedPaneGerenciador.addTab("Agenda Cir\u00FArgica", null, panelAgendaCirurgica, null);
		GridBagLayout gbl_panelAgendaCirurgica = new GridBagLayout();
		gbl_panelAgendaCirurgica.columnWidths = new int[] { 0, 0, 0 };
		gbl_panelAgendaCirurgica.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelAgendaCirurgica.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelAgendaCirurgica.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelAgendaCirurgica.setLayout(gbl_panelAgendaCirurgica);

		JScrollPane scrollPaneAgendaCirurgia = new JScrollPane();
		GridBagConstraints gbc_scrollPaneAgendaCirurgia = new GridBagConstraints();
		gbc_scrollPaneAgendaCirurgia.gridheight = 3;
		gbc_scrollPaneAgendaCirurgia.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneAgendaCirurgia.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneAgendaCirurgia.gridx = 0;
		gbc_scrollPaneAgendaCirurgia.gridy = 1;
		panelAgendaCirurgica.add(scrollPaneAgendaCirurgia, gbc_scrollPaneAgendaCirurgia);

		tableModelCirurgia = new DefaultTableModel();

		tableModelCirurgia.addColumn("Nº Atendimento");
		tableModelCirurgia.addColumn("Procedimento");
		tableModelCirurgia.addColumn("Paciente");
		tableModelCirurgia.addColumn("Data de Cirurgia");

		cirurgias = CirurgiaDAO.getInstance().cirurgiasPorCRM(m.getCrm());

		int i3 = 0;
		for (Cirurgia c : cirurgias) {
			Object[] linha = { c.getCd_atendime(), c.getProcedimento(), c.getPaciente().getNome(),
					c.getDataCirurgia() };
			tableModelCirurgia.insertRow(i3++, linha);

		}
		
		tableAgendaCirurgia = new JTable(tableModelCirurgia);
		tableAgendaCirurgia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lblMsg3.setVisible(false);

				linhaTableCirurgia = tableAgendaCirurgia.getSelectedRow();
				
				cirurgia.setCd_atendime(Integer.parseInt(tableModelCirurgia.getValueAt(linhaTableCirurgia, 0).toString()));
				System.out.println(cirurgia.getCd_atendime());

			}
		});
		scrollPaneAgendaCirurgia.setViewportView(tableAgendaCirurgia);

		txtfBuscarCirurgia = new JTextField();
		txtfBuscarCirurgia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				DefaultTableModel tableModelCirurgia = (DefaultTableModel) tableAgendaCirurgia.getModel();
				tableModelCirurgia.setNumRows(0);

				int i = 0;
				for (Cirurgia c : cirurgias) {
					Object[] linha = { c.getCd_atendime(), c.getProcedimento(), c.getPaciente().getNome(), c.getDataCirurgia()};
					tableModelCirurgia.insertRow(i++, linha);

				}

			}
		});
		GridBagConstraints gbc_txtfBuscarCirurgia = new GridBagConstraints();
		gbc_txtfBuscarCirurgia.insets = new Insets(0, 0, 5, 5);
		gbc_txtfBuscarCirurgia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfBuscarCirurgia.gridx = 0;
		gbc_txtfBuscarCirurgia.gridy = 0;
		panelAgendaCirurgica.add(txtfBuscarCirurgia, gbc_txtfBuscarCirurgia);
		txtfBuscarCirurgia.setColumns(10);

		JButton btnDetalhar = new JButton("Detalhar");
		btnDetalhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if (linhaTableCirurgia >  -1) {
						
						Cirurgia c = CirurgiaDAO.getInstance().cirurgiasPorAtendimento(cirurgia.getCd_atendime());			
						
						RelatorioCirurgiaJFrame r = new RelatorioCirurgiaJFrame(c);
						r.setVisible(true);

					} else {
						throw new Exception("Cirurgia não selecionada");

					}

				} catch (Exception e2) {

					//e2 = new Exception("Paciente não selecionado");
					lblMsg3.setText(e2.getMessage());
					lblMsg3.setForeground(SystemColor.RED);
					lblMsg3.setVisible(true);
					e2.printStackTrace();
				}

			}
		});
		GridBagConstraints gbc_btnDetalhar = new GridBagConstraints();
		gbc_btnDetalhar.insets = new Insets(0, 0, 5, 0);
		gbc_btnDetalhar.anchor = GridBagConstraints.NORTH;
		gbc_btnDetalhar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDetalhar.gridx = 1;
		gbc_btnDetalhar.gridy = 1;
		panelAgendaCirurgica.add(btnDetalhar, gbc_btnDetalhar);
		
		lblMsg3 = new JLabel("");
		lblMsg3.setVisible(false);
		lblMsg3.setFont(new Font("SansSerif", Font.BOLD, 13));
		GridBagConstraints gbc_lblMsg3 = new GridBagConstraints();
		gbc_lblMsg3.insets = new Insets(0, 0, 5, 0);
		gbc_lblMsg3.gridx = 1;
		gbc_lblMsg3.gridy = 2;
		panelAgendaCirurgica.add(lblMsg3, gbc_lblMsg3);

	}

}
