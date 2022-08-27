package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.AtendimentoDAO;
import dao.PacienteDAO;
import model.Atendimento;
import model.Medico;
import model.Paciente;

public class NovoPacienteJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5863167179921604072L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JFormattedTextField tfCpf;
	private JTextField tfEnfermidade;
	private JTextField tfSituacao;
	private JTextField tfDiagnostico;


	/**
	 * Create the frame.
	 */
	public NovoPacienteJFrame(Medico m) {
		setTitle("Novo Paciente\r\n");
		setBounds(100, 100, 450, 381);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Paciente");
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setForeground(SystemColor.textText);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(12, 0, 10, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.disabledForeground"));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(238, 238, 238)), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 15, 10, 15);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 71, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNomePac = new JLabel("Nome:");
		GridBagConstraints gbc_lblNomePac = new GridBagConstraints();
		gbc_lblNomePac.insets = new Insets(0, 10, 5, 5);
		gbc_lblNomePac.anchor = GridBagConstraints.EAST;
		gbc_lblNomePac.gridx = 0;
		gbc_lblNomePac.gridy = 0;
		panel.add(lblNomePac, gbc_lblNomePac);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.insets = new Insets(5, 0, 10, 10);
		gbc_tfNome.fill = GridBagConstraints.BOTH;
		gbc_tfNome.gridx = 1;
		gbc_tfNome.gridy = 0;
		panel.add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		GridBagConstraints gbc_lblCPF = new GridBagConstraints();
		gbc_lblCPF.anchor = GridBagConstraints.EAST;
		gbc_lblCPF.insets = new Insets(0, 10, 10, 5);
		gbc_lblCPF.gridx = 0;
		gbc_lblCPF.gridy = 1;
		panel.add(lblCPF, gbc_lblCPF);
		
		tfCpf = new JFormattedTextField();
		tfCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(tfCpf.getText().length() == 3)
					tfCpf.setText(tfCpf.getText()+".");
				if(tfCpf.getText().length() == 7)
					tfCpf.setText(tfCpf.getText()+".");
				if(tfCpf.getText().length() == 11)
					tfCpf.setText(tfCpf.getText()+"-");
				if(tfCpf.getText().length() == 14)
					e.consume();
					
			}
		});
		GridBagConstraints gbc_tfCpf = new GridBagConstraints();
		gbc_tfCpf.insets = new Insets(0, 0, 10, 10);
		gbc_tfCpf.fill = GridBagConstraints.BOTH;
		gbc_tfCpf.gridx = 1;
		gbc_tfCpf.gridy = 1;
		panel.add(tfCpf, gbc_tfCpf);
		
		JLabel lblEnfermidade = new JLabel("Enfermidade:");
		GridBagConstraints gbc_lblEnfermidade = new GridBagConstraints();
		gbc_lblEnfermidade.anchor = GridBagConstraints.EAST;
		gbc_lblEnfermidade.insets = new Insets(0, 10, 10, 5);
		gbc_lblEnfermidade.gridx = 0;
		gbc_lblEnfermidade.gridy = 2;
		panel.add(lblEnfermidade, gbc_lblEnfermidade);
		
		tfEnfermidade = new JTextField();
		GridBagConstraints gbc_tfEnfermidade = new GridBagConstraints();
		gbc_tfEnfermidade.insets = new Insets(0, 0, 10, 10);
		gbc_tfEnfermidade.fill = GridBagConstraints.BOTH;
		gbc_tfEnfermidade.gridx = 1;
		gbc_tfEnfermidade.gridy = 2;
		panel.add(tfEnfermidade, gbc_tfEnfermidade);
		tfEnfermidade.setColumns(10);
		
		JLabel lblSituacao = new JLabel("Situa\u00E7\u00E3o:");
		GridBagConstraints gbc_lblSituacao = new GridBagConstraints();
		gbc_lblSituacao.anchor = GridBagConstraints.EAST;
		gbc_lblSituacao.insets = new Insets(0, 10, 10, 5);
		gbc_lblSituacao.gridx = 0;
		gbc_lblSituacao.gridy = 3;
		panel.add(lblSituacao, gbc_lblSituacao);
		
		tfSituacao = new JTextField();
		GridBagConstraints gbc_tfSituacao = new GridBagConstraints();
		gbc_tfSituacao.insets = new Insets(0, 0, 10, 10);
		gbc_tfSituacao.fill = GridBagConstraints.BOTH;
		gbc_tfSituacao.gridx = 1;
		gbc_tfSituacao.gridy = 3;
		panel.add(tfSituacao, gbc_tfSituacao);
		tfSituacao.setColumns(10);
		
		JLabel lblDiagnostico = new JLabel("Diagnostico:");
		GridBagConstraints gbc_lblDiagnostico = new GridBagConstraints();
		gbc_lblDiagnostico.anchor = GridBagConstraints.EAST;
		gbc_lblDiagnostico.insets = new Insets(0, 10, 10, 5);
		gbc_lblDiagnostico.gridx = 0;
		gbc_lblDiagnostico.gridy = 4;
		panel.add(lblDiagnostico, gbc_lblDiagnostico);
		
		tfDiagnostico = new JTextField();
		GridBagConstraints gbc_tfDiagnostico = new GridBagConstraints();
		gbc_tfDiagnostico.insets = new Insets(0, 0, 10, 10);
		gbc_tfDiagnostico.fill = GridBagConstraints.BOTH;
		gbc_tfDiagnostico.gridx = 1;
		gbc_tfDiagnostico.gridy = 4;
		panel.add(tfDiagnostico, gbc_tfDiagnostico);
		tfDiagnostico.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		GridBagConstraints gbc_lblDescricao = new GridBagConstraints();
		gbc_lblDescricao.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescricao.insets = new Insets(0, 10, 12, 5);
		gbc_lblDescricao.gridx = 0;
		gbc_lblDescricao.gridy = 5;
		panel.add(lblDescricao, gbc_lblDescricao);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 12, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		panel.add(scrollPane, gbc_scrollPane);
		
		JTextArea taDescricao = new JTextArea();
		scrollPane.setViewportView(taDescricao);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Paciente paciente = new Paciente(tfCpf.getText(), tfNome.getText());
				PacienteDAO.getInstance().cadastrar(paciente);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String data = sdf.format(new Date());

				
				AtendimentoDAO.getInstance().cadastrar(new Atendimento(new Random().nextInt(10000), m, paciente, tfEnfermidade.getText(), tfDiagnostico.getText(), tfSituacao.getText(), taDescricao.getText(), data)); 
				
				AreaTrabalhoPanel.tableModel = (DefaultTableModel) AreaTrabalhoPanel.table.getModel();
				AreaTrabalhoPanel.tableModel.setNumRows(0);

				List<Atendimento> atendimes = AtendimentoDAO.getInstance().pacientesEmAtendimento(m.getCrm());
				int i = 0;

				for (Atendimento a : atendimes) {
					Object[] linha = { a.getPaciente().getCpf(), a.getPaciente().getNome(), a.getEnfermidade(),
							a.getDiagnostico(), a.getSituacao() };
					AreaTrabalhoPanel.tableModel.insertRow(i++, linha);

				}
				
				AreaTrabalhoPanel.table.setModel(AreaTrabalhoPanel.tableModel);
				
				tfCpf.setText(""); 
				tfNome.setText("");
				tfEnfermidade.setText(""); 
				tfDiagnostico.setText("");
				tfSituacao.setText("");
				taDescricao.setText("");
				
				AreaTrabalhoPanel.table.clearSelection();
				
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(5, 0, 12, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

}
