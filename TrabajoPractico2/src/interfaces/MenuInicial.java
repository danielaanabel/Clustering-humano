package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;

public class MenuInicial {

	private JFrame frame;
	private JTextField nombre;
	private JTable table;

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
		frame.setBounds(100, 100, 636, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel agregarPersona = new JLabel("Agregar Personas");
		agregarPersona.setBounds(98, 11, 94, 33);
		frame.getContentPane().add(agregarPersona);
		
		JLabel ingreseNombre = new JLabel("Ingrese nombre:");
		ingreseNombre.setBounds(11, 62, 94, 22);
		frame.getContentPane().add(ingreseNombre);
		
		nombre = new JTextField();
		nombre.setBounds(119, 62, 141, 22);
		frame.getContentPane().add(nombre);
		nombre.setColumns(10);
		
		JLabel intereses = new JLabel("Seleccione sus intereses (siendo 1 el mas bajo y 5 es mas alto)");
		intereses.setBounds(11, 95, 315, 22);
		frame.getContentPane().add(intereses);
		
		JSlider deportes = new JSlider();
		deportes.setMajorTickSpacing(1);
		deportes.setPaintLabels(true);
		deportes.setValue(1);
		deportes.setMinimum(1);
		deportes.setMaximum(5);
		deportes.setBounds(115, 128, 200, 33);
		frame.getContentPane().add(deportes);
		
		JSlider musica = new JSlider();
		musica.setValue(1);
		musica.setPaintLabels(true);
		musica.setMinimum(1);
		musica.setMaximum(5);
		musica.setMajorTickSpacing(1);
		musica.setBounds(115, 172, 200, 33);
		frame.getContentPane().add(musica);
		
		JSlider espectaculos = new JSlider();
		espectaculos.setValue(1);
		espectaculos.setPaintLabels(true);
		espectaculos.setMinimum(1);
		espectaculos.setMaximum(5);
		espectaculos.setMajorTickSpacing(1);
		espectaculos.setBounds(115, 216, 200, 33);
		frame.getContentPane().add(espectaculos);
		
		JSlider ciencia = new JSlider();
		ciencia.setValue(1);
		ciencia.setPaintLabels(true);
		ciencia.setMinimum(1);
		ciencia.setMaximum(5);
		ciencia.setMajorTickSpacing(1);
		ciencia.setBounds(115, 260, 200, 33);
		frame.getContentPane().add(ciencia);
		
		JLabel etiquetaDeportes = new JLabel("Deportes");
		etiquetaDeportes.setBounds(21, 128, 70, 22);
		frame.getContentPane().add(etiquetaDeportes);
		
		JLabel etiquetaMusica = new JLabel("M\u00FAsica");
		etiquetaMusica.setBounds(21, 177, 46, 14);
		frame.getContentPane().add(etiquetaMusica);
		
		JLabel etiquetaEspectaculos = new JLabel("Espect\u00E1culos");
		etiquetaEspectaculos.setBounds(21, 221, 70, 14);
		frame.getContentPane().add(etiquetaEspectaculos);
		
		JLabel etiquetaCiencia = new JLabel("Ciencia");
		etiquetaCiencia.setBounds(21, 260, 46, 14);
		frame.getContentPane().add(etiquetaCiencia);
		
		JButton guardarPersona = new JButton("Guardar Datos");
		guardarPersona.setBounds(129, 330, 150, 38);
		frame.getContentPane().add(guardarPersona);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Nombre", "iD", "iM", "iE", "iC"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(25);
		table.getColumnModel().getColumn(4).setPreferredWidth(25);
		table.setBounds(588, 286, -168, -229);
		frame.getContentPane().add(table);
	}
}
