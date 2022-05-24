package principal;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pantallas.PanelLogin;

public class Principal extends JFrame {
	JPanel panelVisual;

	public Principal() {
		super("Muvirentia");
		panelVisual = new JPanel(new CardLayout());
		this.setSize(1000, 600);
		this.setLocation(200, 100);
		this.setContentPane(panelVisual);
		cambiarPanel(crearPanelLogin());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JPanel crearPanelLogin() {
		JPanel panel;
		PanelLogin panelLogin = new PanelLogin();
		panel = panelLogin.getPanel();
		return panel;
	}

	private JPanel cambiarPanel(JPanel nuevoPanel) {
		panelVisual.removeAll();
		panelVisual.add(nuevoPanel);
		panelVisual.repaint();
		panelVisual.revalidate();
		return panelVisual;
	}

	private Container crearPanelVentana() {
		JPanel panel = new JPanel();

		return panel;
	}

	public static void main(String[] args) {
		Principal programa = new Principal();
	}

}
