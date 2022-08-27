package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import controller.MedicoController;
import main.Main;
import model.Medico;

public class CadastrarMedicoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4572161850795170165L;
	private JPasswordField txtfSenha;
	private JLabel lblMsg;
	private JTextField txtfNome;
	private JTextField txtfEspecialidade;
	private MaskFormatter mask;
	private JFormattedTextField txtfCrm;

	public CadastrarMedicoPanel() {

		setBackground(SystemColor.activeCaption);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);

		JLabel lblTituloPanel = new JLabel("Sistema Hospitalar");
		lblTituloPanel.setBackground(SystemColor.menuText);
		lblTituloPanel.setForeground(SystemColor.desktop);
		lblTituloPanel.setFont(new Font("SansSerif", Font.PLAIN, 21));
		GridBagConstraints gbc_lblTituloPanel = new GridBagConstraints();
		gbc_lblTituloPanel.anchor = GridBagConstraints.SOUTH;
		gbc_lblTituloPanel.weighty = 1.0;
		gbc_lblTituloPanel.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloPanel.gridx = 0;
		gbc_lblTituloPanel.gridy = 0;
		add(lblTituloPanel, gbc_lblTituloPanel);

		JPanel panelDados = new JPanel();
		panelDados.setForeground(SystemColor.controlText);
		panelDados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panelDados = new GridBagConstraints();
		gbc_panelDados.anchor = GridBagConstraints.NORTH;
		gbc_panelDados.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelDados.insets = new Insets(10, 10, 10, 10);
		gbc_panelDados.gridx = 0;
		gbc_panelDados.gridy = 1;
		add(panelDados, gbc_panelDados);
		GridBagLayout gbl_panelDados = new GridBagLayout();
		gbl_panelDados.columnWidths = new int[] { 0, 157, 45 };
		gbl_panelDados.rowHeights = new int[] { 0, 21, 38, 37, 38, 0, 0, 0 };
		gbl_panelDados.columnWeights = new double[] { 1.0, 1.0, 0.0 };
		gbl_panelDados.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelDados.setLayout(gbl_panelDados);

		JLabel lblTitulo = new JLabel("Cadastro M\u00E9dico");
		lblTitulo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.insets = new Insets(20, 20, 15, 20);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panelDados.add(lblTitulo, gbc_lblTitulo);

		JLabel lblCPF = new JLabel("CRM:");
		lblCPF.setFont(new Font("SansSerif", Font.BOLD, 13));
		GridBagConstraints gbc_lblCPF = new GridBagConstraints();
		gbc_lblCPF.anchor = GridBagConstraints.EAST;
		gbc_lblCPF.insets = new Insets(10, 20, 10, 5);
		gbc_lblCPF.gridx = 0;
		gbc_lblCPF.gridy = 1;
		panelDados.add(lblCPF, gbc_lblCPF);
		
		try {
			mask = new MaskFormatter("######");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		txtfCrm = new JFormattedTextField(mask);
		txtfCrm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblMsg.setVisible(false);
				
			}
		});
		txtfCrm.setColumns(10);
		GridBagConstraints gbc_txtfCrm = new GridBagConstraints();
		gbc_txtfCrm.fill = GridBagConstraints.BOTH;
		gbc_txtfCrm.insets = new Insets(5, 0, 5, 0);
		gbc_txtfCrm.gridx = 1;
		gbc_txtfCrm.gridy = 1;
		panelDados.add(txtfCrm, gbc_txtfCrm);

		JComboBox<String> comboBoxUF = new JComboBox<String>();
		comboBoxUF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtfCrm.setText(txtfCrm.getText());
				comboBoxUF.setSelectedIndex(0);
			}
		});
		comboBoxUF.setModel(new DefaultComboBoxModel<String>(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		GridBagConstraints gbc_comboBoxUF = new GridBagConstraints();
		gbc_comboBoxUF.insets = new Insets(5, 0, 5, 20);
		gbc_comboBoxUF.fill = GridBagConstraints.BOTH;
		gbc_comboBoxUF.gridx = 2;
		gbc_comboBoxUF.gridy = 1;
		panelDados.add(comboBoxUF, gbc_comboBoxUF);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 13));
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 10, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 2;
		panelDados.add(lblNome, gbc_lblNome);

		txtfNome = new JTextField();
		txtfNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblMsg.setVisible(false);

			}
		});
		GridBagConstraints gbc_txtfNome = new GridBagConstraints();
		gbc_txtfNome.anchor = GridBagConstraints.NORTH;
		gbc_txtfNome.gridwidth = 2;
		gbc_txtfNome.insets = new Insets(5, 0, 5, 20);
		gbc_txtfNome.fill = GridBagConstraints.BOTH;
		gbc_txtfNome.gridx = 1;
		gbc_txtfNome.gridy = 2;
		panelDados.add(txtfNome, gbc_txtfNome);
		txtfNome.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("SansSerif", Font.BOLD, 13));
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(10, 10, 10, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 3;
		panelDados.add(lblSenha, gbc_lblSenha);

		txtfSenha = new JPasswordField();
		txtfSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblMsg.setVisible(false);
			}
		});
		GridBagConstraints gbc_txtf = new GridBagConstraints();
		gbc_txtf.gridwidth = 2;
		gbc_txtf.fill = GridBagConstraints.BOTH;
		gbc_txtf.insets = new Insets(5, 0, 5, 20);
		gbc_txtf.gridx = 1;
		gbc_txtf.gridy = 3;
		panelDados.add(txtfSenha, gbc_txtf);
		txtfSenha.setColumns(10);

		lblMsg = new JLabel();
		GridBagConstraints gbc_lblMsg = new GridBagConstraints();
		gbc_lblMsg.insets = new Insets(0, 0, 5, 0);
		gbc_lblMsg.gridwidth = 3;
		gbc_lblMsg.gridx = 0;
		gbc_lblMsg.gridy = 4;
		panelDados.add(lblMsg, gbc_lblMsg);

		JLabel lblEspecialidade = new JLabel("Especialidade:");
		lblEspecialidade.setFont(new Font("SansSerif", Font.BOLD, 13));
		GridBagConstraints gbc_lblEspecialidade = new GridBagConstraints();
		gbc_lblEspecialidade.insets = new Insets(0, 10, 5, 5);
		gbc_lblEspecialidade.anchor = GridBagConstraints.EAST;
		gbc_lblEspecialidade.gridx = 0;
		gbc_lblEspecialidade.gridy = 4;
		panelDados.add(lblEspecialidade, gbc_lblEspecialidade);

		txtfEspecialidade = new JTextField();
		GridBagConstraints gbc_txtfEspecialidade = new GridBagConstraints();
		gbc_txtfEspecialidade.gridwidth = 2;
		gbc_txtfEspecialidade.insets = new Insets(5, 0, 5, 20);
		gbc_txtfEspecialidade.fill = GridBagConstraints.BOTH;
		gbc_txtfEspecialidade.gridx = 1;
		gbc_txtfEspecialidade.gridy = 4;
		panelDados.add(txtfEspecialidade, gbc_txtfEspecialidade);
		txtfEspecialidade.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Medico m = new Medico();

				m.setCrm(txtfCrm.getText());
				String senha = new String(txtfSenha.getPassword());
				m.setSenha(senha);
				m.setUf((String)comboBoxUF.getSelectedItem());
				m.setEspecialidade(txtfEspecialidade.getText());
				m.setNome(txtfNome.getText());
				
				MedicoController medicoController = new MedicoController();
				try {
					medicoController.cadastrar(m);
					
					txtfCrm.setText("");
					txtfNome.setText("");
					txtfSenha.setText("");
					txtfEspecialidade.setText("");
					comboBoxUF.setSelectedIndex(0);
					
					lblMsg.setText("Cadastrado!");
					lblMsg.setForeground(SystemColor.GREEN);
					lblMsg.setVisible(true);
					
				} catch (Exception ex) {
					
					lblMsg.setText(ex.getMessage());
					lblMsg.setForeground(SystemColor.RED);
					lblMsg.setVisible(true);
					
				}

			}
		});
		btnCadastrar.setForeground(SystemColor.text);
		btnCadastrar.setBackground(SystemColor.textHighlight);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.insets = new Insets(10, 0, 20, 0);
		gbc_btnCadastrar.gridwidth = 3;
		gbc_btnCadastrar.gridx = 0;
		gbc_btnCadastrar.gridy = 5;
		panelDados.add(btnCadastrar, gbc_btnCadastrar);
		
		lblMsg = new JLabel("");
		lblMsg.setFont(new Font("SansSerif", Font.ITALIC, 13));
		lblMsg.setVisible(false);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 6;
		panelDados.add(lblMsg, gbc_lblNewLabel);

		JLabel lblVoltar = new JLabel("<html><u>Voltar</u></html>");
		lblVoltar.setForeground(SystemColor.WHITE);
		lblVoltar.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {

				lblVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblVoltar.setForeground(SystemColor.BLUE);
			}
		});
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblVoltar.setForeground(SystemColor.WHITE);

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				Main.getFrame().setContentPane(new LoginPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});

		lblVoltar.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_lblVoltar = new GridBagConstraints();
		gbc_lblVoltar.anchor = GridBagConstraints.NORTH;
		gbc_lblVoltar.weighty = 1.7;
		gbc_lblVoltar.gridx = 0;
		gbc_lblVoltar.gridy = 2;
		add(lblVoltar, gbc_lblVoltar);

	}

}
