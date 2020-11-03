package interfaces;


import java.util.ArrayList;

import javax.swing.JFrame;

public class visualizarGrupos {

	private JFrame frame;
	private ArrayList<String> g1;
	private ArrayList<String> g2;


	/**
	 * Create the application.
	 */
	public visualizarGrupos(ArrayList<String> grupo1, ArrayList<String> grupo2) {
		g1=grupo1;
		g2=grupo2;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(770, 100, 400, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		for (String e: g1) {
			System.out.println(e);
		}
		System.out.println();
		for (String f: g2) {
			System.out.println(f);
		}
		
	}

	public JFrame getFrame() {
		return frame;
	}

	

}
