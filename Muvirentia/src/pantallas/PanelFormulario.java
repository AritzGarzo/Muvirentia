package pantallas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import principal.Controlador;

public class PanelFormulario extends JFrame {
	Controlador controlador;
	JPanel panel;
	JButton bHome,bMenu;
	
	public PanelFormulario(Controlador controlador) {
		this.controlador = controlador;
		
		//definir como se ve el panel
		panel = new JPanel(new BorderLayout(0,10));
		panel.add(crearPanelNorte(),BorderLayout.NORTH);
		panel.add(crearPanelLista(),BorderLayout.CENTER);
		
	}

	private Component crearPanelNorte() {
		JPanel panel = new JPanel();
		
		
		
		return panel;
	}

	private Component crearPanelLista() {
		JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		
		return scroll;
	}
	
	
	private void enviarFormulario() {
		//Por implementar
		//pero puedes guardarlo
	}

	private Component crearPanelBotones() {
		JPanel panel = new JPanel(new GridLayout(2,1,0,50));
		
		
		
		return panel;
	}
	
}
