package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import model.Cirurgia;
import model.Enfermeiro;

public class RelatorioCirurgiaJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7909296372756755063L;

	/**
	 * Create the application.
	 * 
	 * 
	 */
	
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RelatorioCirurgiaJFrame(Cirurgia c) throws Exception{
		
		setVisible(false);
		setTitle("Cirurgia");
		setBounds(100, 100, 550, 700);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblPaciente = new JLabel("Paciente: "+c.getPaciente().getNome());
		GridBagConstraints gbc_lblPaciente = new GridBagConstraints();
		gbc_lblPaciente.insets = new Insets(10, 10, 10, 10);
		gbc_lblPaciente.gridx = 0;
		gbc_lblPaciente.gridy = 0;
		getContentPane().add(lblPaciente, gbc_lblPaciente);
		
		JLabel lblNewLabel = new JLabel("Cirurgia: "+c.getProcedimento());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 10, 10, 10);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panelDescricao = new JPanel();
		panelDescricao.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDescricao = new GridBagConstraints();
		gbc_panelDescricao.insets = new Insets(0, 10, 10, 10);
		gbc_panelDescricao.fill = GridBagConstraints.BOTH;
		gbc_panelDescricao.gridx = 0;
		gbc_panelDescricao.gridy = 2;
		getContentPane().add(panelDescricao, gbc_panelDescricao);
		GridBagLayout gbl_panelDescricao = new GridBagLayout();
		gbl_panelDescricao.columnWidths = new int[]{0, 0};
		gbl_panelDescricao.rowHeights = new int[]{0, 0};
		gbl_panelDescricao.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelDescricao.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelDescricao.setLayout(gbl_panelDescricao);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panelDescricao.add(scrollPane, gbc_scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(c.getObservacao());
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Auxiliadores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(10, 10, 10, 10);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblEnfermeiros = new JLabel("Enfermeiros");
		GridBagConstraints gbc_lblEnfermeiros = new GridBagConstraints();
		gbc_lblEnfermeiros.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnfermeiros.gridx = 0;
		gbc_lblEnfermeiros.gridy = 0;
		panel.add(lblEnfermeiros, gbc_lblEnfermeiros);
		
		JLabel lblNewLabel_2 = new JLabel("Instrumentos");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JList listEnfermeiros = new JList();
		GridBagConstraints gbc_listEnfermeiros = new GridBagConstraints();
		gbc_listEnfermeiros.insets = new Insets(0, 4, 4, 2);
		gbc_listEnfermeiros.fill = GridBagConstraints.BOTH;
		gbc_listEnfermeiros.gridx = 0;
		gbc_listEnfermeiros.gridy = 1;
		panel.add(listEnfermeiros, gbc_listEnfermeiros);
		
		List<String> nomeEnfermeiros= new ArrayList<String>();
		
		for(Enfermeiro enf:c.getEnfermeiros())
			nomeEnfermeiros.add(enf.getNome());
		
		
		listEnfermeiros.setListData(nomeEnfermeiros.toArray());
		
		JList listInstrumentos = new JList<String>();
		
		listInstrumentos.setListData(c.getFerramentas().toArray());
		GridBagConstraints gbc_listInstrumentos = new GridBagConstraints();
		gbc_listInstrumentos.insets = new Insets(0, 2, 4, 4);
		gbc_listInstrumentos.fill = GridBagConstraints.BOTH;
		gbc_listInstrumentos.gridx = 1;
		gbc_listInstrumentos.gridy = 1;
		panel.add(listInstrumentos, gbc_listInstrumentos);
		
	}

}
