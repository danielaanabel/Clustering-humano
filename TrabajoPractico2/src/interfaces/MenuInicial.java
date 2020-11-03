package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 677, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel agregarPersona = new JLabel("Agregar Personas");
		agregarPersona.setBounds(98, 11, 128, 33);
		frame.getContentPane().add(agregarPersona);

		JLabel ingreseNombre = new JLabel("Ingrese nombre:");
		ingreseNombre.setBounds(11, 62, 94, 22);
		frame.getContentPane().add(ingreseNombre);

		aviso = new JLabel("");
		aviso.setBounds(289, 66, 251, 18);
		frame.getContentPane().add(aviso);

		nombre = new JTextField();
		nombre.setBounds(119, 62, 141, 22);
		frame.getContentPane().add(nombre);
		nombre.setColumns(10);

		deportes = new JSlider();
		deportes.setMajorTickSpacing(1);
		deportes.setPaintLabels(true);
		deportes.setValue(1);
		deportes.setMinimum(1);
		deportes.setMaximum(5);
		deportes.setBounds(115, 128, 200, 33);
		frame.getContentPane().add(deportes);

		musica = new JSlider();
		musica.setValue(1);
		musica.setPaintLabels(true);
		musica.setMinimum(1);
		musica.setMaximum(5);
		musica.setMajorTickSpacing(1);
		musica.setBounds(115, 172, 200, 33);
		frame.getContentPane().add(musica);

		espectaculos = new JSlider();
		espectaculos.setValue(1);
		espectaculos.setPaintLabels(true);
		espectaculos.setMinimum(1);
		espectaculos.setMaximum(5);
		espectaculos.setMajorTickSpacing(1);
		espectaculos.setBounds(115, 216, 200, 33);
		frame.getContentPane().add(espectaculos);

		ciencia = new JSlider();
		ciencia.setValue(1);
		ciencia.setPaintLabels(true);
		ciencia.setMinimum(1);
		ciencia.setMaximum(5);
		ciencia.setMajorTickSpacing(1);
		ciencia.setBounds(115, 260, 200, 33);
		frame.getContentPane().add(ciencia);

		JLabel intereses = new JLabel("Seleccione sus intereses (siendo 1 el mas bajo y 5 es mas alto)");
		intereses.setBounds(11, 95, 372, 22);
		frame.getContentPane().add(intereses);

		JLabel etiquetaDeportes = new JLabel("Deportes");
		etiquetaDeportes.setBounds(21, 128, 70, 22);
		frame.getContentPane().add(etiquetaDeportes);

		JLabel etiquetaMusica = new JLabel("M\u00FAsica");
		etiquetaMusica.setBounds(21, 172, 70, 14);
		frame.getContentPane().add(etiquetaMusica);

		JLabel etiquetaEspectaculos = new JLabel("Espect\u00E1culos");
		etiquetaEspectaculos.setBounds(21, 216, 84, 14);
		frame.getContentPane().add(etiquetaEspectaculos);

		JLabel etiquetaCiencia = new JLabel("Ciencia");
		etiquetaCiencia.setBounds(21, 260, 84, 14);
		frame.getContentPane().add(etiquetaCiencia);

		JButton guardarPersona = new JButton("Guardar Datos");
		guardarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nombre.getText().length()<3 || nombre.getText().length()>12) {
					aviso.setText("¡Debe ingresar nombres entre 2 y 12 letras!");
				}
				else {
					Object[] nuevaFila= {nombre.getText(),deportes.getValue(),musica.getValue(),
							espectaculos.getValue(),ciencia.getValue()};
					modelo.addRow(nuevaFila);
					//resetear los intereses y nombre.
					limpiarDatos();
				}


			}});
		guardarPersona.setBounds(129, 330, 150, 38);
		frame.getContentPane().add(guardarPersona);

		table = new JTable();
		table.setRowHeight(18);
		modelo=new DefaultTableModel();
		modelo.addColumn("nombre");
		modelo.addColumn("id");
		modelo.addColumn("im");
		modelo.addColumn("ie");
		modelo.addColumn("ic");
		modelo.addRow(new String[] {"Nombre","iD","iM","iE","iC"});
		//		modelo.addRow(new Object[] {"Daniela",1,4,3,2});
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(22);
		table.getColumnModel().getColumn(2).setPreferredWidth(22);
		table.getColumnModel().getColumn(3).setPreferredWidth(22);
		table.getColumnModel().getColumn(4).setPreferredWidth(22);
		table.setBounds(378, 120, 251, 209);
		frame.getContentPane().add(table);	


	}

	public void limpiarDatos() {
		deportes.setValue(1);
		musica.setValue(1);
		espectaculos.setValue(1);
		ciencia.setValue(1);
		nombre.setText("");
		aviso.setText("");
	}



}
