package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import src.Formulario;
import src.MiDialogo;

public class Controlador implements ActionListener,ListSelectionListener {
	public final static String PANEL_PRINCIPAL="panel_principal",
			PANEL_FORMULARIO="panel_formulario",
			PANEL_LOGIN="panel_login",
			PANEL_GRAFICO="panel_grafico",
			PANEL_MENU="panel_menu",
			FORMULARIO="formulario";
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
			Formulario formulario = dialogo.getFormulario();
			if(formulario!=null) conector.firePropertyChange("formulario", null, formulario);
			break;
		case PANEL_GRAFICO:
			break;
		default:
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
