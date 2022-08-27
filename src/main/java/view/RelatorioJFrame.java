package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.AtendimentoDAO;
import model.Atendimento;
import model.Medico;
import model.Paciente;

public class RelatorioJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7680001271135370574L;
	private JTable tableHistorico;
	private List<Atendimento> atendimes;
	private int linhaTable;
	private Atendimento atendimento;
	private JTextArea textArea;
	private JButton btnAlta;

	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RelatorioJFrame(Paciente p, Medico m) throws Exception{
		getContentPane().setBackground(SystemColor.inactiveCaption);
		
		AreaTrabalhoPanel.table.clearSelection();

		setVisible(false);
		setTitle("Relatório " + p.getNome());
		setBounds(100, 100, 550, 700);
		setLocationRelativeTo(null);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblPaciente = new JLabel(p.getNome());
		lblPaciente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPaciente = new GridBagConstraints();
		gbc_lblPaciente.insets = new Insets(10, 0, 5, 0);
		gbc_lblPaciente.gridx = 0;
		gbc_lblPaciente.gridy = 0;
		getContentPane().add(lblPaciente, gbc_lblPaciente);

		JPanel panelHistoricoPac = new JPanel();
		panelHistoricoPac.setBackground(SystemColor.inactiveCaption);
		panelHistoricoPac
				.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Hist\u00F3rico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_panelHistoricoPac = new GridBagConstraints();
		gbc_panelHistoricoPac.insets = new Insets(0, 5, 10, 0);
		gbc_panelHistoricoPac.fill = GridBagConstraints.BOTH;
		gbc_panelHistoricoPac.gridx = 0;
		gbc_panelHistoricoPac.gridy = 1;
		getContentPane().add(panelHistoricoPac, gbc_panelHistoricoPac);
		GridBagLayout gbl_panelHistoricoPac = new GridBagLayout();
		gbl_panelHistoricoPac.columnWidths = new int[] { 213, 0 };
		gbl_panelHistoricoPac.rowHeights = new int[] { 2, 0 };
		gbl_panelHistoricoPac.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelHistoricoPac.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panelHistoricoPac.setLayout(gbl_panelHistoricoPac);

		JScrollPane scrollPaneHistoricoPac = new JScrollPane();
		GridBagConstraints gbc_scrollPaneHistoricoPac = new GridBagConstraints();
		gbc_scrollPaneHistoricoPac.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneHistoricoPac.gridx = 0;
		gbc_scrollPaneHistoricoPac.gridy = 0;
		panelHistoricoPac.add(scrollPaneHistoricoPac, gbc_scrollPaneHistoricoPac);

		DefaultTableModel tableModel = new DefaultTableModel();

		tableModel.addColumn("Nº Atendimento");
		tableModel.addColumn("Data Atendimento");
		tableModel.addColumn("Enfermidade");
		tableModel.addColumn("Situação");

		atendimes = AtendimentoDAO.getInstance().buscarAtendimentoPorCPFeCRM(p.getCpf(), m.getCrm());
		int i = 0;

		for (Atendimento a : atendimes) {
			Object[] linha = {a.getCd_atendime(), a.getData(), a.getEnfermidade(), a.getSituacao() };
			tableModel.insertRow(i++, linha);

		}

		tableHistorico = new JTable(tableModel);
		tableHistorico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				linhaTable = tableHistorico.getSelectedRow();
				int cd_atendime = Integer.parseInt(tableHistorico.getValueAt(linhaTable, 0).toString());
				
				try {
					atendimento = AtendimentoDAO.getInstance().buscarAtendimentoPorCd_Atendimento(cd_atendime);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(atendimento.getSituacao() != "liberado(a)") 
					btnAlta.setEnabled(true);
				if (atendimento.getSituacao().equalsIgnoreCase("liberado(a)"))
					btnAlta.setEnabled(false);
				
					
				textArea.setText(atendimento.getDescricao());
				
			}
		});
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;

		scrollPaneHistoricoPac.setViewportView(tableHistorico);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 5, 10, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 211, 0 };
		gbl_panel.rowHeights = new int[] { 22, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JScrollPane scrollPaneDescricao = new JScrollPane();
		GridBagConstraints gbc_scrollPaneDescricao = new GridBagConstraints();
		gbc_scrollPaneDescricao.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneDescricao.gridx = 0;
		gbc_scrollPaneDescricao.gridy = 0;
		panel.add(scrollPaneDescricao, gbc_scrollPaneDescricao);

		textArea = new JTextArea();
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 0;
		// panel.add(textArea, gbc_textArea);

		scrollPaneDescricao.setViewportView(textArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 10, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnEditarDescricao = new JButton("Alterar descri\u00E7\u00E3o");
		btnEditarDescricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setEditable(true);
			}
		});
		GridBagConstraints gbc_btnEditarDescricao = new GridBagConstraints();
		gbc_btnEditarDescricao.anchor = GridBagConstraints.EAST;
		gbc_btnEditarDescricao.insets = new Insets(0, 0, 0, 10);
		gbc_btnEditarDescricao.gridx = 0;
		gbc_btnEditarDescricao.gridy = 0;
		panel_1.add(btnEditarDescricao, gbc_btnEditarDescricao);
		
		btnAlta = new JButton("Alta");
		btnAlta.setEnabled(false);
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				linhaTable = tableHistorico.getSelectedRow();
				int cd_atendime = Integer.parseInt(tableHistorico.getValueAt(linhaTable, 0).toString());
				
				try {
					atendimento = AtendimentoDAO.getInstance().buscarAtendimentoPorCd_Atendimento(cd_atendime);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
				
				atendimento.setSituacao("Liberado(a)");
				
				AtendimentoDAO.getInstance().atualizarAtendimento(atendimento);
				
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
				
				atendimes = AtendimentoDAO.getInstance().buscarAtendimentoPorCPFeCRM(p.getCpf(), m.getCrm());
				int i1 = 0;

				tableModel.setNumRows(0);
				for (Atendimento a : atendimes) {
					Object[] linha = {a.getCd_atendime(), a.getData(), a.getEnfermidade(), a.getSituacao() };
					tableModel.insertRow(i1++, linha);

				}

				tableHistorico = new JTable(tableModel);
				AreaTrabalhoPanel.table.clearSelection();
				tableHistorico.clearSelection();

			}
		});
		GridBagConstraints gbc_btnAlta = new GridBagConstraints();
		gbc_btnAlta.insets = new Insets(0, 10, 0, 0);
		gbc_btnAlta.anchor = GridBagConstraints.WEST;
		gbc_btnAlta.weightx = 1.0;
		gbc_btnAlta.gridx = 1;
		gbc_btnAlta.gridy = 0;
		panel_1.add(btnAlta, gbc_btnAlta);

	}

}
