package pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import principal.Controlador;

public class PanelPrincipal extends JFrame implements ActionListener {
	Controlador controlador;
	JPanel panel;
	JButton bMenu,bUsuario,bValvula;
	boolean valvula = false;
	JLabel lbLuz,lbTemperatura,lbHumedad;
	
	public PanelPrincipal(Controlador controlador) {
		this.controlador = controlador;
		
		
		panel = new JPanel(new BorderLayout(0,20));
		panel.add(crearPanelNorte(),BorderLayout.NORTH);
		panel.add(crearPanelCentro(),BorderLayout.CENTER);
	}
	
	private Component crearPanelNorte() {
		JPanel panel = new JPanel();
		
		bMenu = new JButton("Menu");
		bMenu.setActionCommand(Controlador.PANEL_MENU);
		bMenu.addActionListener(controlador);
		
		bUsuario = new JButton("Txillu");//colocar nombre del usuario
		bUsuario.setActionCommand(Controlador.PANEL_LOGIN);
		bUsuario.addActionListener(controlador);
		
		panel.add(bMenu);
		panel.add(bUsuario);
		return panel;
	}

	private Component crearPanelCentro() {
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		split.setDividerLocation(200);
		
		split.add(crearPanelVisualizacion());
		split.add(crearPanelValvula());
		return split;
	}

	private Component crearPanelVisualizacion() {
		JPanel panel = new JPanel(new GridLayout(3,1,0,30));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		lbLuz = new JLabel();
		lbLuz.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Luz: "),
				BorderFactory.createLoweredBevelBorder()));
		lbLuz.setBackground(null);
		
		lbHumedad = new JLabel();
		lbHumedad.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Humedad: "),
				BorderFactory.createLoweredBevelBorder()));
		lbHumedad.setBackground(null);
		
		lbTemperatura = new JLabel();
		lbTemperatura.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Temperatura: "),
				BorderFactory.createLoweredBevelBorder()));
		lbTemperatura.setBackground(null);
		
		
		panel.add(lbLuz);
		panel.add(lbHumedad);
		panel.add(lbTemperatura);
		return panel;
	}

	private Component crearPanelValvula() {
		JPanel panel = new JPanel();
		
		bValvula = new JButton("Valvula: "+((valvula)?"ON":"OFF"));
		bValvula.setActionCommand("valvula");
		bValvula.addActionListener(this);
		
		panel.add(bValvula);
		return panel;
	}

	public JPanel getPanel() {return panel;}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals("valvula")) {
			valvula = !valvula;
			bValvula.setText("Valvula: "+((valvula)?"ON":"OFF"));
		}
	}
}
