package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import baseDeDatos.ConexionDB;
import pantallas.PanelMenu;
import src.DialogoPlanta;
import src.FormularioAniadir;
import src.FormularioIncidencia;
import src.MiDialogo;
import src.Usuario;

public class Controlador implements ActionListener, ListSelectionListener, PropertyChangeListener {
	public final static String PANEL_PRINCIPAL = "panel_principal", PANEL_LOGIN = "panel_login",
			PANEL_GRAFICO = "panel_grafico", PANEL_MENU = "panel_menu", FORMULARIO = "formulario",
			ADD_PLANTA = "add_planta", DEL_PLANTA = "del_planta", SISTEMA = "sistema", CONFIRMAR = "confirmar",
			CANCELAR = "cancelar", APAGAR = "apagar";
	PropertyChangeSupport conector;
	Usuario usuario;

	public Controlador() {
		conector = new PropertyChangeSupport(this);
	}

	public void addListener(PropertyChangeListener listener) {
		conector.addPropertyChangeListener(listener);
	}

	public void removeListener(PropertyChangeListener listener) {
		conector.removePropertyChangeListener(listener);
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
		case PANEL_PRINCIPAL:
			conector.firePropertyChange(PANEL_PRINCIPAL, null, usuario);
			break;
		case PANEL_LOGIN:
			conector.firePropertyChange(PANEL_LOGIN,null,12);
			break;
		case FORMULARIO:
			MiDialogo dialogo = new MiDialogo(new JFrame(), "Formulario", true);
			FormularioIncidencia formulario = dialogo.getFormulario();
			if (formulario != null)
				conector.firePropertyChange(FORMULARIO, null, formulario);
			break;
		case PANEL_MENU:
			conector.firePropertyChange(PANEL_MENU, null, 12);
			break;
		case ADD_PLANTA:
			DialogoPlanta dialogoPlanta = new DialogoPlanta(new JFrame(), "Agregar Planta", true);
			FormularioAniadir formularioAniadir = dialogoPlanta.getFormulario();
			if (formularioAniadir != null)
				conector.firePropertyChange(ADD_PLANTA, null, formularioAniadir);
			break;
		case DEL_PLANTA:
			conector.firePropertyChange(DEL_PLANTA, null, null);
			break;
		case SISTEMA:
			conector.firePropertyChange(SISTEMA, null, 12);
			break;
		default:
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propiedad = evt.getPropertyName();
		switch (propiedad) {
		case CONFIRMAR:
			Usuario usuario = (Usuario) evt.getNewValue();
			conector.firePropertyChange(PANEL_PRINCIPAL, null, usuario);
			break;
		case CANCELAR:
			conector.firePropertyChange(APAGAR, false, true);
			break;
		default:
		}
	}
}
