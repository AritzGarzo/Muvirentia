package principal;

import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pantallas.PanelLogin;
import pantallas.PanelMenu;
import pantallas.PanelPrincipal;
import src.Usuario;

public class Principal extends JFrame implements PropertyChangeListener {
	JPanel panelVisual;
	Controlador controlador;
	AbstractAction acc;
	Usuario usuario;
	
	public Principal(Controlador controlador) {
		super("Muvirentia");
		this.controlador = controlador;
		controlador.addListener(this);

		this.setSize(1000, 600);
		this.setLocation(200, 100);
		panelVisual = new JPanel(new CardLayout());
		this.setContentPane(panelVisual);
		cambiarPanel(crearPanelLogin(usuario));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//ey
	}
//prueba
	// ---------------------------paneles---------------------------

	private JPanel crearPanelLogin(Usuario usuario) {
		JPanel panel;
		PanelLogin panelLogin = new PanelLogin(controlador,usuario);
		panel = panelLogin.getPanel();
		return panel;
	}
		
	private JPanel crearPanelMenu(Usuario usuario) {
		JPanel panel;
		PanelMenu panelMenu = new PanelMenu(controlador,usuario);
		panel = panelMenu.getPanel();
		return panel;
	}
	
	private JPanel crearPanelPrincipal(Usuario usuario) {
		JPanel panel;
		PanelPrincipal panelPrincipal = new PanelPrincipal(controlador,usuario);
		panel = panelPrincipal.getPanel();
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
			usuario = (Usuario)evt.getNewValue();
			controlador.setUsuario(usuario);
			cambiarPanel(crearPanelPrincipal(usuario));
			break;
		case Controlador.PANEL_MENU:
			cambiarPanel(crearPanelMenu(usuario));
			break;
		case Controlador.APAGAR:
			Principal.this.dispose();
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
