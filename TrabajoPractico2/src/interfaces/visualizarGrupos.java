package interfaces;


import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;


public class visualizarGrupos {

	private JFrame ventanaVerGrupos;
	private ArrayList<HashSet<String>> grupos;
	private JTable tabla1;
	private JTable tabla2;

	/**
	 * Create the application.
	 */
	public visualizarGrupos(ArrayList<HashSet<String>> g) {
		grupos=g;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ventanaVerGrupos = new JFrame();
		ventanaVerGrupos.getContentPane().setBackground(Color.WHITE);
		ventanaVerGrupos.setIconImage(Toolkit.getDefaultToolkit().getImage(visualizarGrupos.class.getResource("/img/icono.png")));
		ventanaVerGrupos.setTitle("Clustering humano");
		ventanaVerGrupos.setResizable(false);
		ventanaVerGrupos.setBounds(790, 100, 400, 504);
		ventanaVerGrupos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaVerGrupos.getContentPane().setLayout(null);
		
		DefaultTableModel modelo1=new DefaultTableModel();
		modelo1.addColumn("Nombre");
		
		DefaultTableModel modelo2=new DefaultTableModel();
		modelo2.addColumn("Nombre");
		
		
		tabla1 = new JTable();
		tabla1.setRowSelectionAllowed(false);
		tabla1.setShowGrid(false);
		tabla1.setFocusable(false);
		tabla1.setSelectionBackground(SystemColor.activeCaption);
		tabla1.setGridColor(SystemColor.activeCaption);
		tabla1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		tabla1.setBounds(43, 64, 137, 299);
		tabla1.setModel(modelo1);
		
		DefaultTableCellRenderer cabecera=new DefaultTableCellRenderer();
		cabecera.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		cabecera.setBackground(new Color(146, 222, 252));
		tabla1.getColumnModel().getColumn(0).setHeaderRenderer(cabecera);
		
		
		tabla2 = new JTable();
		tabla2.setRowSelectionAllowed(false);
		tabla2.setFocusable(false);
		tabla2.setSelectionBackground(SystemColor.activeCaption);
		tabla2.setShowGrid(false);
		tabla2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		tabla2.setBounds(218, 64, 137, 299);
		tabla2.setModel(modelo2);
		
		tabla2.getColumnModel().getColumn(0).setHeaderRenderer(cabecera);
		
		
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
		etiquetaGrupo1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		etiquetaGrupo1.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaGrupo1.setBounds(71, 27, 76, 26);
		ventanaVerGrupos.getContentPane().add(etiquetaGrupo1);
		
		JLabel etiquetaGrupo2 = new JLabel("Grupo 2");
		etiquetaGrupo2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		etiquetaGrupo2.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaGrupo2.setBounds(243, 27, 76, 26);
		ventanaVerGrupos.getContentPane().add(etiquetaGrupo2);
		
		for (String nombre : grupos.get(0)) {
			modelo1.addRow(new Object[] {nombre});
		}
		for (String nombre : grupos.get(1)) {
			modelo2.addRow(new Object[] {nombre});
		}		
		
	}

	public JFrame getFrame() {
		return ventanaVerGrupos;
	}
}
