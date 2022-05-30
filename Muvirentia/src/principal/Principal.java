package principal;

import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pantallas.PanelLogin;

public class Principal extends JFrame implements PropertyChangeListener {
	JPanel panelVisual;
	Controlador controlador;

	public Principal(Controlador controlador) {
		super("Muvirentia");
		this.controlador = controlador;
		panelVisual = new JPanel(new CardLayout());
		this.setSize(1000, 600);
		this.setLocation(200, 100);
		this.setContentPane(panelVisual);
		cambiarPanel(crearPanelLogin());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//---------------------------paneles---------------------------
	
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
	
	//---------------------property change listener---------------------

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propiedad = evt.getPropertyName();
		switch(propiedad) {
		case Controlador.PANEL_PRINCIPAL:
			break;
		default:
			
		}
	}
	
	
	//----------------------------graficos----------------------------
	
	//------------------------------main------------------------------

	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		Principal programa = new Principal(controlador);
	}
}
