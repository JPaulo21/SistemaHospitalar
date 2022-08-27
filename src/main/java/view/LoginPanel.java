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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import controller.LoginController;
import controller.MedicoController;
import main.Main;
import model.Login;
import model.Medico;

public class LoginPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2607264486146393893L;
	private JPasswordField txtfSenha;
	private JFormattedTextField txtfCrm;
	private JLabel lblMsg;
	private MaskFormatter mascara;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
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
		gbl_panelDados.columnWidths = new int[] { 0, 171, 0, 0 };
		gbl_panelDados.rowHeights = new int[] { 0, 46, 51, 0, 44, 0 };
		gbl_panelDados.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelDados.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelDados.setLayout(gbl_panelDados);

		JLabel lblTitulo = new JLabel("Acesse sua área de trabalho");
		lblTitulo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.insets = new Insets(20, 20, 20, 20);
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
		
		JComboBox<String> comboBoxUF = new JComboBox<String>();
		comboBoxUF.setModel(new DefaultComboBoxModel<String>(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		GridBagConstraints gbc_comboBoxUF = new GridBagConstraints();
		gbc_comboBoxUF.anchor = GridBagConstraints.WEST;
		gbc_comboBoxUF.insets = new Insets(10, 0, 10, 20);
		gbc_comboBoxUF.fill = GridBagConstraints.VERTICAL;
		gbc_comboBoxUF.gridx = 2;
		gbc_comboBoxUF.gridy = 1;
		panelDados.add(comboBoxUF, gbc_comboBoxUF);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("SansSerif", Font.BOLD, 13));
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(10, 10, 15, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 2;
		panelDados.add(lblSenha, gbc_lblSenha);

		try {
			mascara = new MaskFormatter("######");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtfCrm = new JFormattedTextField(mascara);
		txtfCrm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtfCrm.setText(null);
				lblMsg.setVisible(false);
			}
		});

		GridBagConstraints gbc_txtfCPF = new GridBagConstraints();
		gbc_txtfCPF.insets = new Insets(10, 0, 9, 0);
		gbc_txtfCPF.fill = GridBagConstraints.BOTH;
		gbc_txtfCPF.gridx = 1;
		gbc_txtfCPF.gridy = 1;
		panelDados.add(txtfCrm, gbc_txtfCPF);
		txtfCrm.setColumns(10);

		txtfSenha = new JPasswordField();
		GridBagConstraints gbc_txtf = new GridBagConstraints();
		gbc_txtf.gridwidth = 2;
		gbc_txtf.anchor = GridBagConstraints.NORTH;
		gbc_txtf.insets = new Insets(10, 0, 15, 20);
		gbc_txtf.fill = GridBagConstraints.BOTH;
		gbc_txtf.gridx = 1;
		gbc_txtf.gridy = 2;
		panelDados.add(txtfSenha, gbc_txtf);
		txtfSenha.setColumns(10);

		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login l = new Login();
				l.setCrm(txtfCrm.getText());
				l.setSenha(new String(txtfSenha.getPassword()));
				l.setUf((String)comboBoxUF.getSelectedItem());

				LoginController loginController = new LoginController();
				try {

					if(loginController.logar(l)) {
						
						MedicoController medicoController = new MedicoController();
						Medico m = medicoController.buscarPorCRMeUF(l.getCrm(), l.getUf());	
						
						Main.getFrame().setContentPane(new AreaTrabalhoPanel(m));
						Main.getFrame().getContentPane().revalidate();
					} 
					
				} catch (Exception ex) {

					lblMsg.setVisible(true);
					lblMsg.setForeground(SystemColor.RED);
					lblMsg.setText(ex.getMessage());
				}

			}
		});

		lblMsg = new JLabel("");
		lblMsg.setVisible(false);

		GridBagConstraints gbc_lblMsg = new GridBagConstraints();
		gbc_lblMsg.insets = new Insets(0, 0, 5, 0);
		gbc_lblMsg.gridwidth = 3;
		gbc_lblMsg.gridx = 0;
		gbc_lblMsg.gridy = 3;
		panelDados.add(lblMsg, gbc_lblMsg);
		btnAcessar.setForeground(Color.WHITE);
		btnAcessar.setBackground(SystemColor.textHighlight);
		btnAcessar.setFont(new Font("SansSerif", Font.PLAIN, 14));

		GridBagConstraints gbc_btnAcessar = new GridBagConstraints();
		gbc_btnAcessar.insets = new Insets(10, 0, 20, 0);
		gbc_btnAcessar.gridwidth = 3;
		gbc_btnAcessar.gridx = 0;
		gbc_btnAcessar.gridy = 4;
		panelDados.add(btnAcessar, gbc_btnAcessar);
		
		JLabel lblCadastrar = new JLabel("<html><u>Cadastrar</u></html>");
		lblCadastrar.setForeground(SystemColor.WHITE);
		lblCadastrar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				lblCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblCadastrar.setForeground(SystemColor.BLUE);
			}
		});
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblCadastrar.setForeground(SystemColor.WHITE);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Main.getFrame().setContentPane(new CadastrarMedicoPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});

		lblCadastrar.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_lblCadastrar = new GridBagConstraints();
		gbc_lblCadastrar.anchor = GridBagConstraints.NORTH;
		gbc_lblCadastrar.weighty = 1.7;
		gbc_lblCadastrar.gridx = 0;
		gbc_lblCadastrar.gridy = 2;
		add(lblCadastrar, gbc_lblCadastrar);

	}

}
