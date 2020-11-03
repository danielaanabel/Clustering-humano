package interfaces;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TP2.Ejecutar;
import TP2.GrupoDePersonas;
import TP2.Persona;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;


public class MenuInicial {

	private JFrame frame;
	private JTextField nombre;
	private JTable table;
	private DefaultTableModel modelo;
	private JSlider deportes;
	private JSlider musica;
	private JSlider espectaculos;
	private JSlider ciencia;
	private JLabel aviso;
	private JLabel avisoPersonasVacio;
	private JButton ejecutar;
	private GrupoDePersonas listaPersonas;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial window = new MenuInicial();
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
	public MenuInicial() {
		listaPersonas=new GrupoDePersonas();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 683, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.getContentPane().setLayout(null);

		JLabel agregarPersona = new JLabel("Agregar Personas");
		agregarPersona.setBounds(98, 11, 128, 33);
		frame.getContentPane().add(agregarPersona);

		JLabel ingreseNombre = new JLabel("Ingrese nombre:");
		ingreseNombre.setBounds(11, 62, 98, 33);
		frame.getContentPane().add(ingreseNombre);

		avisoPersonasVacio = new JLabel("");
		avisoPersonasVacio.setBounds(432, 351, 200, 18);
		frame.getContentPane().add(avisoPersonasVacio);

		aviso = new JLabel("");
		aviso.setBounds(289, 66, 251, 18);
		frame.getContentPane().add(aviso);

		nombre = new JTextField();
		nombre.setBounds(119, 62, 150, 33);
		frame.getContentPane().add(nombre);
		nombre.setColumns(10);

		deportes = new JSlider();
		deportes.setMajorTickSpacing(1);
		deportes.setPaintLabels(true);
		deportes.setValue(1);
		deportes.setMinimum(1);
		deportes.setMaximum(5);
		deportes.setBounds(115, 164, 200, 33);
		frame.getContentPane().add(deportes);

		musica = new JSlider();
		musica.setValue(1);
		musica.setPaintLabels(true);
		musica.setMinimum(1);
		musica.setMaximum(5);
		musica.setMajorTickSpacing(1);
		musica.setBounds(115, 208, 200, 33);
		frame.getContentPane().add(musica);

		espectaculos = new JSlider();
		espectaculos.setValue(1);
		espectaculos.setPaintLabels(true);
		espectaculos.setMinimum(1);
		espectaculos.setMaximum(5);
		espectaculos.setMajorTickSpacing(1);
		espectaculos.setBounds(115, 252, 200, 33);
		frame.getContentPane().add(espectaculos);

		ciencia = new JSlider();
		ciencia.setValue(1);
		ciencia.setPaintLabels(true);
		ciencia.setMinimum(1);
		ciencia.setMaximum(5);
		ciencia.setMajorTickSpacing(1);
		ciencia.setBounds(115, 296, 200, 33);
		frame.getContentPane().add(ciencia);

		JLabel intereses = new JLabel("Seleccione sus intereses (siendo 1 el mas bajo y 5 es mas alto)");
		intereses.setBounds(10, 117, 362, 22);
		frame.getContentPane().add(intereses);

		JLabel etiquetaDeportes = new JLabel("Deportes");
		etiquetaDeportes.setBounds(21, 164, 70, 22);
		frame.getContentPane().add(etiquetaDeportes);

		JLabel etiquetaMusica = new JLabel("M\u00FAsica");
		etiquetaMusica.setBounds(21, 208, 70, 14);
		frame.getContentPane().add(etiquetaMusica);

		JLabel etiquetaEspectaculos = new JLabel("Espect\u00E1culos");
		etiquetaEspectaculos.setBounds(21, 255, 84, 14);
		frame.getContentPane().add(etiquetaEspectaculos);

		JLabel etiquetaCiencia = new JLabel("Ciencia");
		etiquetaCiencia.setBounds(21, 296, 84, 14);
		frame.getContentPane().add(etiquetaCiencia);

		JButton guardarPersona = new JButton("Guardar Datos");
		guardarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nombre.getText().length()<3 || nombre.getText().length()>12) 
					aviso.setText("�Debe ingresar nombres entre 2 y 12 letras!");
				else {
					Object[] nuevaFila= {nombre.getText(),deportes.getValue(),musica.getValue(),
							espectaculos.getValue(),ciencia.getValue()};
					modelo.addRow(nuevaFila);
					Persona p1=new Persona(nombre.getText(),
							deportes.getValue(),musica.getValue(),
							espectaculos.getValue(), ciencia.getValue());
					listaPersonas.agregarPersona(p1);

					//resetear los intereses y nombre.
					limpiarDatos();
				}

			}});
		guardarPersona.setBounds(119, 392, 150, 38);
		frame.getContentPane().add(guardarPersona);

		ejecutar = new JButton("Calcular Grupos");
		ejecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listaPersonas.cantPersonas()==0) 
					avisoPersonasVacio.setText("Debe agregar personas a la lista");	
				else {
					ArrayList<ArrayList<String>> grupos=Ejecutar.calcularGrupos(listaPersonas);
					//ver si se puede mejorar para que ver grupos reciba como parametro directamente grupos
					visualizarGrupos verGrupos=new visualizarGrupos(grupos.get(0),grupos.get(1));
					verGrupos.getFrame().setVisible(true);
				}	

			}
		});
		ejecutar.setBounds(446, 392, 143, 38);
		frame.getContentPane().add(ejecutar);

		modelo=new DefaultTableModel();
		modelo.addColumn("nombre");
		modelo.addColumn("iD");
		modelo.addColumn("iM");
		modelo.addColumn("iE");
		modelo.addColumn("iC");
		//modelo.addRow(new String[] {"Nombre","iD","iM","iE","iC"});

		table = new JTable();
		table.setBorder(null);
		table.setRowHeight(22);
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setMinWidth(90);
		table.getColumnModel().getColumn(1).setMinWidth(35);
		table.getColumnModel().getColumn(2).setMinWidth(35);
		table.getColumnModel().getColumn(3).setMinWidth(35);
		table.getColumnModel().getColumn(4).setMinWidth(35);
		table.setBounds(400, 120, 251, 209);
		//frame.getContentPane().add(table);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(SystemColor.inactiveCaption, 5, true));
		scrollPane.setBounds(400, 120, 251, 209);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
	}

	public void limpiarDatos() {
		deportes.setValue(1);
		musica.setValue(1);
		espectaculos.setValue(1);
		ciencia.setValue(1);
		nombre.setText("");
		aviso.setText("");
		avisoPersonasVacio.setText("");
	}
}
