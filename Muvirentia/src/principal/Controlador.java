package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Controlador implements ActionListener {
	public final static String PANEL_PRINCIPAL="principal",
			PANEL_FORMULARIO="formulario",
			PANEL_LOGIN="login",
			PANEL_GRAFICO="grafico",
			PANEL_MENU="menu";
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
		// TODO Auto-generated method stub
		
	}
}
