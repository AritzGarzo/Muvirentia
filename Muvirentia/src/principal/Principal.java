package principal;

import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;

import baseDeDatos.ConexionDB;
import pantallas.PanelLogin;
import pantallas.PanelMenu;

public class Principal extends JFrame implements PropertyChangeListener {
	JPanel panelVisual;
	Controlador controlador;
	AbstractAction acc;
	ConexionDB db=new ConexionDB();


	public Principal(Controlador controlador) {
		super("Muvirentia");
		this.setSize(800, 600);
		PanelMenu panel = new PanelMenu(controlador);
		this.setContentPane(panel.getPanel());
		db.getPlanta();
	
		
		/*this.controlador = controlador;
		controlador.addListener(this);
		
		panelVisual = new JPanel(new CardLayout());
		this.setSize(1000, 600);
		this.setLocation(200, 100);
		this.setContentPane(panelVisual);
		cambiarPanel(crearPanelLogin());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		this.setVisible(true);
	}

	// ---------------------------paneles---------------------------

	private JPanel crearPanelLogin() {
		JPanel panel;
		PanelLogin panelLogin = new PanelLogin();
		panel = panelLogin.getPanel();
		return panel;
	}
	
	private JPanel crearPanelMenu() {
		JPanel panel;
		PanelMenu panelMenu = new PanelMenu(controlador);
		panel = panelMenu.getPanel();
		return panel;
	}

	private JPanel cambiarPanel(JPanel nuevoPanel) {
		panelVisual.removeAll();
		panelVisual.add(nuevoPanel);
		panelVisual.repaint();
		panelVisual.revalidate();
		return panelVisual;
	}

	// ---------------------property change listener---------------------

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propiedad = evt.getPropertyName();
		switch (propiedad) {
		case Controlador.PANEL_PRINCIPAL:
			break;
		default:

		}
	}

	// ----------------------------graficos----------------------------

	// ------------------------------main------------------------------

	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		Principal programa = new Principal(controlador);

	}
}
