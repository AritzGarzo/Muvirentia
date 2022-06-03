package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pantallas.PanelMenu;
import src.DialogoPlanta;
import src.FormularioAniadir;
import src.FormularioIncidencia;
import src.MiDialogo;

public class Controlador implements ActionListener,ListSelectionListener {
	public final static String PANEL_PRINCIPAL="panel_principal",
			PANEL_LOGIN="panel_login",
			PANEL_GRAFICO="panel_grafico",
			PANEL_MENU="panel_menu",
			FORMULARIO="formulario",
			ADD_PLANTA="add_planta",
			DEL_PLANTA="del_planta",
			SISTEMA="sistema";
	PropertyChangeSupport conector;
	
	public Controlador() {
		conector = new PropertyChangeSupport(this);
	}
	
	public void addListener(PropertyChangeListener listener) {
		conector.addPropertyChangeListener(listener);
	}
	
	public void removeListener(PropertyChangeListener listener) {
		conector.removePropertyChangeListener(listener);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch(comando) {
		case FORMULARIO:
			MiDialogo dialogo = new MiDialogo(new JFrame(),"Formulario",true);
			FormularioIncidencia formulario = dialogo.getFormulario();
			if(formulario!=null) conector.firePropertyChange(FORMULARIO, null, formulario);
			break;
		case PANEL_MENU:
				conector.firePropertyChange(PANEL_MENU, null, 12);
			break;
		case ADD_PLANTA:
			DialogoPlanta dialogoPlanta=new DialogoPlanta(new JFrame(),"Agregar Planta",true);
			FormularioAniadir formularioAniadir=dialogoPlanta.getFormulario();
			if (formularioAniadir!=null) conector.firePropertyChange(ADD_PLANTA, null, formularioAniadir);
			break;
		case DEL_PLANTA:
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
}
