package interfaces;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import TP2.GrupoDePersonas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		listaPersonas=new GrupoDePersonas();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ventanaInicio = new JFrame();
		ventanaInicio.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuInicial.class.getResource("/img/icono.png")));
		ventanaInicio.setTitle("Clustering humano");
		ventanaInicio.setResizable(false);
		ventanaInicio.setBounds(100, 100, 687, 504);
		ventanaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaInicio.getContentPane().setLayout(null);
		
		JLabel intereses = new JLabel("Seleccione sus intereses (siendo 1 el mas bajo y 5 es mas alto)");
		intereses.setBackground(Color.WHITE);
		intereses.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		intereses.setBounds(10, 117, 410, 30);
		ventanaInicio.getContentPane().add(intereses);

		JLabel agregarPersona = new JLabel("Agregar Personas");
		agregarPersona.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		agregarPersona.setBounds(96, 17, 172, 33);
		ventanaInicio.getContentPane().add(agregarPersona);

		JLabel ingreseNombre = new JLabel("Ingrese nombre:");
		ingreseNombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		ingreseNombre.setBounds(10, 61, 109, 33);
		ventanaInicio.getContentPane().add(ingreseNombre);

		avisoPersonasVacio = new JLabel("");
		avisoPersonasVacio.setBackground(Color.WHITE);
		avisoPersonasVacio.setHorizontalAlignment(SwingConstants.CENTER);
		avisoPersonasVacio.setForeground(Color.RED);
		avisoPersonasVacio.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		avisoPersonasVacio.setBounds(414, 380, 225, 22);
		ventanaInicio.getContentPane().add(avisoPersonasVacio);

		aviso = new JLabel("");
		aviso.setForeground(Color.RED);
		aviso.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		aviso.setBounds(67, 99, 271, 18);
		ventanaInicio.getContentPane().add(aviso);

		nombre = new JTextField();
		nombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		nombre.setBorder(new LineBorder(SystemColor.inactiveCaption, 2, true));
		nombre.setBounds(129, 62, 150, 33);
		ventanaInicio.getContentPane().add(nombre);
		nombre.setColumns(10);

		deportes = new JSlider();
		deportes.setBackground(Color.WHITE);
		deportes.setToolTipText("");
		deportes.setPaintLabels(true);
		deportes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		deportes.setRequestFocusEnabled(false);
		deportes.setMajorTickSpacing(1);
		deportes.setValue(1);
		deportes.setMinimum(1);
		deportes.setMaximum(5);
		deportes.setBounds(138, 164, 200, 33);
		ventanaInicio.getContentPane().add(deportes);

		musica = new JSlider();
		musica.setBackground(Color.WHITE);
		musica.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		musica.setRequestFocusEnabled(false);
		musica.setValue(1);
		musica.setPaintLabels(true);
		musica.setMinimum(1);
		musica.setMaximum(5);
		musica.setMajorTickSpacing(1);
		musica.setBounds(138, 208, 200, 33);
		ventanaInicio.getContentPane().add(musica);

		espectaculos = new JSlider();
		espectaculos.setBackground(Color.WHITE);
		espectaculos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		espectaculos.setRequestFocusEnabled(false);
		espectaculos.setValue(1);
		espectaculos.setPaintLabels(true);
		espectaculos.setMinimum(1);
		espectaculos.setMaximum(5);
		espectaculos.setMajorTickSpacing(1);
		espectaculos.setBounds(138, 252, 200, 33);
		ventanaInicio.getContentPane().add(espectaculos);

		ciencia = new JSlider();
		ciencia.setBackground(Color.WHITE);
		ciencia.setName("");
		ciencia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		ciencia.setRequestFocusEnabled(false);
		ciencia.setValue(1);
		ciencia.setPaintLabels(true);
		ciencia.setMinimum(1);
		ciencia.setMaximum(5);
		ciencia.setMajorTickSpacing(1);
		ciencia.setBounds(138, 296, 200, 33);
		ventanaInicio.getContentPane().add(ciencia);

		JLabel etiquetaDeportes = new JLabel("Deportes");
		etiquetaDeportes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		etiquetaDeportes.setBounds(21, 164, 70, 22);
		ventanaInicio.getContentPane().add(etiquetaDeportes);

		JLabel etiquetaMusica = new JLabel("M\u00FAsica");
		etiquetaMusica.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		etiquetaMusica.setBounds(21, 208, 70, 14);
		ventanaInicio.getContentPane().add(etiquetaMusica);

		JLabel etiquetaEspectaculos = new JLabel("Espect\u00E1culos");
		etiquetaEspectaculos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		etiquetaEspectaculos.setBounds(21, 252, 98, 14);
		ventanaInicio.getContentPane().add(etiquetaEspectaculos);

		JLabel etiquetaCiencia = new JLabel("Ciencia");
		etiquetaCiencia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		etiquetaCiencia.setBounds(21, 296, 86, 18);
		ventanaInicio.getContentPane().add(etiquetaCiencia);
		
		modelo=new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("iD");
		modelo.addColumn("iM");
		modelo.addColumn("iE");
		modelo.addColumn("iC");
		
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setShowVerticalLines(false);
		table.setFocusable(false);
		table.setSelectionForeground(Color.BLACK);
		table.setSelectionBackground(SystemColor.activeCaption);
		table.setBackground(Color.WHITE);
		table.setGridColor(SystemColor.activeCaption);
		table.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		table.setBorder(null);
		table.setRowHeight(22);
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setMaxWidth(99);
		table.getColumnModel().getColumn(1).setMaxWidth(38);
		table.getColumnModel().getColumn(2).setMaxWidth(38);
		table.getColumnModel().getColumn(3).setMaxWidth(38);
		table.getColumnModel().getColumn(4).setMaxWidth(38);
		table.setBounds(400, 120, 251, 209);
		
		DefaultTableCellRenderer cabecera=new DefaultTableCellRenderer();
		cabecera.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		cabecera.setBackground(new Color(146, 222, 252));
		table.getColumnModel().getColumn(0).setHeaderRenderer(cabecera);
		table.getColumnModel().getColumn(1).setHeaderRenderer(cabecera);
		table.getColumnModel().getColumn(2).setHeaderRenderer(cabecera);
		table.getColumnModel().getColumn(3).setHeaderRenderer(cabecera);
		table.getColumnModel().getColumn(4).setHeaderRenderer(cabecera);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(SystemColor.inactiveCaption, 5, true));
		scrollPane.setBounds(391, 158, 257, 222);
		ventanaInicio.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

		JButton guardarPersona = new JButton("Guardar Datos");
		guardarPersona.setFocusable(false);
		guardarPersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				guardarPersona.setBackground(new Color(146, 222, 252));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				guardarPersona.setBackground(Color.white);
			}
		});
		guardarPersona.setBorder(new LineBorder(SystemColor.inactiveCaption, 2, true));
		guardarPersona.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		guardarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nombre.getText().length()<3 || nombre.getText().length()>12) 
					aviso.setText("¡Debe ingresar nombres entre 3 y 12 letras!");
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
		guardarPersona.setBounds(118, 364, 150, 38);
		ventanaInicio.getContentPane().add(guardarPersona);

		JButton ejecutar = new JButton("Calcular Grupos");
		ejecutar.setFocusable(false);
		ejecutar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ejecutar.setBackground(new Color(146, 222, 252));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ejecutar.setBackground(Color.white);
			}
		});
		ejecutar.setBorder(new LineBorder(SystemColor.inactiveCaption, 2));
		ejecutar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
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
		ejecutar.setBounds(446, 405, 143, 38);
		ventanaInicio.getContentPane().add(ejecutar);
		
		
		JButton cargarListaJSON = new JButton("Cargar lista pre-cargada");
		cargarListaJSON.setFocusable(false);
		cargarListaJSON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cargarListaJSON.setBackground(new Color(146, 222, 252));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cargarListaJSON.setBackground(Color.white);
			}
		});
		cargarListaJSON.setBorder(new LineBorder(new Color(191, 205, 219), 2, true));
		cargarListaJSON.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		cargarListaJSON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GrupoDePersonas listaDePersonasJSON=GrupoDePersonas.leerJSON("personas.JSON");
				listaPersonas.anexarListaPersonas(listaDePersonasJSON);
				
				for (int i = 0; i < listaDePersonasJSON.cantPersonas(); i++) {
					String nombre=listaDePersonasJSON.getPersonas().get(i).getNombre();
					int id=listaDePersonasJSON.getPersonas().get(i).getiDeportes();
					int im=listaDePersonasJSON.getPersonas().get(i).getiMusica();
					int ie=listaDePersonasJSON.getPersonas().get(i).getiEspectaculos();
					int ic=listaDePersonasJSON.getPersonas().get(i).getiCiencia();
					
					modelo.addRow(new Object[] {nombre,id,im,ie,ic});
					avisoPersonasVacio.setText("");
				}
			}
		});
		cargarListaJSON.setBounds(61, 423, 263, 30);
		ventanaInicio.getContentPane().add(cargarListaJSON);
		
		JLabel fondoJSlide = new JLabel("");
		fondoJSlide.setIcon(new ImageIcon(MenuInicial.class.getResource("/img/fondo_blanco.jpg")));
		fondoJSlide.setForeground(new Color(0, 0, 0));
		fondoJSlide.setBackground(Color.WHITE);
		fondoJSlide.setBounds(138, 158, 200, 171);
		ventanaInicio.getContentPane().add(fondoJSlide);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(MenuInicial.class.getResource("/img/grafoPersonas2.png")));
		fondo.setBounds(0, 0, 681, 475);
		ventanaInicio.getContentPane().add(fondo);
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
