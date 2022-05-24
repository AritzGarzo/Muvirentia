package principal;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal extends JFrame {
	
	public Principal() {
		super("Muvirentia");
		
		this.setSize(1000, 600);
		this.setLocation(200, 100);
		this.setContentPane(crearPanelVentana());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private Container crearPanelVentana() {
		JPanel panel = new JPanel();
		
		return panel;
	}

	public static void main(String[] args) {
		Principal programa = new Principal();
	}

}
