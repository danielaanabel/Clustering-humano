package interfaces;


import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class visualizarGrupos {

	private JFrame ventanaVerGrupos;
	private ArrayList<ArrayList<String>> grupos;
	private JTable tabla1;
	private JTable tabla2;

	/**
	 * Create the application.
	 */
	public visualizarGrupos(ArrayList<ArrayList<String>> g) {
		grupos=g;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ventanaVerGrupos = new JFrame();
		ventanaVerGrupos.setTitle("Clustering humano");
		ventanaVerGrupos.setResizable(false);
		ventanaVerGrupos.setBounds(770, 100, 400, 481);
		ventanaVerGrupos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaVerGrupos.getContentPane().setLayout(null);
		
		DefaultTableModel modelo1=new DefaultTableModel();
		modelo1.addColumn("Nombre");
		
		DefaultTableModel modelo2=new DefaultTableModel();
		modelo2.addColumn("Nombre");
		
		
		tabla1 = new JTable();
		tabla1.setBounds(43, 64, 137, 299);
		tabla1.setModel(modelo1);
		
		tabla2 = new JTable();
		tabla2.setBounds(218, 64, 137, 299);
		tabla2.setModel(modelo2);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(SystemColor.inactiveCaption, 5, true));
		scrollPane.setBounds(39, 64, 143, 299);
		ventanaVerGrupos.getContentPane().add(scrollPane);
		scrollPane.setViewportView(tabla1);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBorder(new LineBorder(SystemColor.inactiveCaption, 5, true));
		scrollPane2.setBounds(212, 64, 143, 299);
		ventanaVerGrupos.getContentPane().add(scrollPane2);
		scrollPane2.setViewportView(tabla2);
		
		JLabel etiquetaGrupo1 = new JLabel("Grupo 1");
		etiquetaGrupo1.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaGrupo1.setBounds(79, 27, 57, 26);
		ventanaVerGrupos.getContentPane().add(etiquetaGrupo1);
		
		JLabel etiquetaGrupo2 = new JLabel("Grupo 2");
		etiquetaGrupo2.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaGrupo2.setBounds(251, 27, 57, 26);
		ventanaVerGrupos.getContentPane().add(etiquetaGrupo2);
		
		for(int i=0;i<grupos.size();i++) {
			for(int j=0;j<grupos.get(i).size();j++) {
				if(i==0)
					modelo1.addRow(new Object[] {grupos.get(i).get(j)});
				else
					modelo2.addRow(new Object[] {grupos.get(i).get(j)});
			}
		}
			
		
	}

	public JFrame getFrame() {
		return ventanaVerGrupos;
	}
}
