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

import TP2.GrupoDePersonas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;


public class MenuInicial {

	private JFrame ventanaInicio;
	private JTable table;
	private DefaultTableModel modelo;
	private JTextField nombre;
	private JSlider deportes;
	private JSlider musica;
	private JSlider espectaculos;
	private JSlider ciencia;
	private JLabel aviso;
	private JLabel avisoPersonasVacio;
	private GrupoDePersonas listaPersonas;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial window = new MenuInicial();
					window.ventanaInicio.setVisible(true);
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
		ventanaInicio = new JFrame();
		ventanaInicio.setTitle("Clustering humano");
		ventanaInicio.setResizable(false);
		ventanaInicio.setBounds(100, 100, 683, 481);
		ventanaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaInicio.getContentPane().setLayout(null);

		JLabel agregarPersona = new JLabel("Agregar Personas");
		agregarPersona.setBounds(98, 11, 128, 33);
		ventanaInicio.getContentPane().add(agregarPersona);

		JLabel ingreseNombre = new JLabel("Ingrese nombre:");
		ingreseNombre.setBounds(11, 62, 98, 33);
		ventanaInicio.getContentPane().add(ingreseNombre);

		avisoPersonasVacio = new JLabel("");
		avisoPersonasVacio.setBounds(432, 351, 200, 18);
		ventanaInicio.getContentPane().add(avisoPersonasVacio);

		aviso = new JLabel("");
		aviso.setBounds(289, 66, 251, 18);
		ventanaInicio.getContentPane().add(aviso);

		nombre = new JTextField();
		nombre.setBounds(119, 62, 150, 33);
		ventanaInicio.getContentPane().add(nombre);
		nombre.setColumns(10);

		deportes = new JSlider();
		deportes.setMajorTickSpacing(1);
		deportes.setPaintLabels(true);
		deportes.setValue(1);
		deportes.setMinimum(1);
		deportes.setMaximum(5);
		deportes.setBounds(115, 164, 200, 33);
		ventanaInicio.getContentPane().add(deportes);

		musica = new JSlider();
		musica.setValue(1);
		musica.setPaintLabels(true);
		musica.setMinimum(1);
		musica.setMaximum(5);
		musica.setMajorTickSpacing(1);
		musica.setBounds(115, 208, 200, 33);
		ventanaInicio.getContentPane().add(musica);

		espectaculos = new JSlider();
		espectaculos.setValue(1);
		espectaculos.setPaintLabels(true);
		espectaculos.setMinimum(1);
		espectaculos.setMaximum(5);
		espectaculos.setMajorTickSpacing(1);
		espectaculos.setBounds(115, 252, 200, 33);
		ventanaInicio.getContentPane().add(espectaculos);

		ciencia = new JSlider();
		ciencia.setValue(1);
		ciencia.setPaintLabels(true);
		ciencia.setMinimum(1);
		ciencia.setMaximum(5);
		ciencia.setMajorTickSpacing(1);
		ciencia.setBounds(115, 296, 200, 33);
		ventanaInicio.getContentPane().add(ciencia);

		JLabel intereses = new JLabel("Seleccione sus intereses (siendo 1 el mas bajo y 5 es mas alto)");
		intereses.setBounds(10, 117, 362, 22);
		ventanaInicio.getContentPane().add(intereses);

		JLabel etiquetaDeportes = new JLabel("Deportes");
		etiquetaDeportes.setBounds(21, 164, 70, 22);
		ventanaInicio.getContentPane().add(etiquetaDeportes);

		JLabel etiquetaMusica = new JLabel("M\u00FAsica");
		etiquetaMusica.setBounds(21, 208, 70, 14);
		ventanaInicio.getContentPane().add(etiquetaMusica);

		JLabel etiquetaEspectaculos = new JLabel("Espect\u00E1culos");
		etiquetaEspectaculos.setBounds(21, 255, 84, 14);
		ventanaInicio.getContentPane().add(etiquetaEspectaculos);

		JLabel etiquetaCiencia = new JLabel("Ciencia");
		etiquetaCiencia.setBounds(21, 296, 84, 14);
		ventanaInicio.getContentPane().add(etiquetaCiencia);
		
		modelo=new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("iD");
		modelo.addColumn("iM");
		modelo.addColumn("iE");
		modelo.addColumn("iC");
		
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(SystemColor.inactiveCaption, 5, true));
		scrollPane.setBounds(400, 120, 251, 209);
		ventanaInicio.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

		JButton guardarPersona = new JButton("Guardar Datos");
		guardarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nombre.getText().length()<3 || nombre.getText().length()>12) 
					aviso.setText("¡Debe ingresar nombres entre 2 y 12 letras!");
				else {
					Object[] nuevaFila= {nombre.getText(),deportes.getValue(),musica.getValue(),
							espectaculos.getValue(),ciencia.getValue()};
					modelo.addRow(nuevaFila);
					
					listaPersonas.agregarPersona(nombre.getText(),
							deportes.getValue(),musica.getValue(),
							espectaculos.getValue(), ciencia.getValue());

					//resetear los intereses y nombre.
					limpiarDatos();
				}
			}});
		guardarPersona.setBounds(119, 392, 150, 38);
		ventanaInicio.getContentPane().add(guardarPersona);

		JButton ejecutar = new JButton("Calcular Grupos");
		ejecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listaPersonas.cantPersonas()==0) 
					avisoPersonasVacio.setText("Debe agregar personas a la lista");	
				else {
					visualizarGrupos verGrupos=new visualizarGrupos(GrupoDePersonas.calcularGrupos(listaPersonas));
					verGrupos.getFrame().setVisible(true);
				}	
			}
		});
		ejecutar.setBounds(446, 392, 143, 38);
		ventanaInicio.getContentPane().add(ejecutar);
		
		
		JButton cargarListaJSON = new JButton("Cargar lista pre-cargada");
		cargarListaJSON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				listaPersonas=GrupoDePersonas.leerJSON("personas.JSON");
				
				for (int i = 0; i < listaPersonas.cantPersonas(); i++) {
	
					String nombre=listaPersonas.getPersonas().get(i).getNombre();
					int id=listaPersonas.getPersonas().get(i).getiDeportes();
					int im=listaPersonas.getPersonas().get(i).getiMusica();
					int ie=listaPersonas.getPersonas().get(i).getiEspectaculos();
					int ic=listaPersonas.getPersonas().get(i).getiCiencia();
					
					modelo.addRow(new Object[] {nombre,id,im,ie,ic});
				}
			}
		});
		cargarListaJSON.setBounds(32, 351, 258, 23);
		ventanaInicio.getContentPane().add(cargarListaJSON);
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
