package pantallas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import principal.Controlador;
import src.Usuario;

public class PanelLogin implements ActionListener {
	JPanel panel;
	JTextField tNombre;
	JPasswordField pPass;
	JButton bConfirm,bCancel;
	Usuario usuario;
	Controlador controlador;
	PropertyChangeSupport conector;
	
	public PanelLogin(Controlador controlador) {
		this.controlador = controlador;
		conector = new PropertyChangeSupport(this);
		conector.addPropertyChangeListener(controlador);
		
		panel = new JPanel(new GridLayout(2,2,60,60));
		crearPanel();
	}
	
	public void setUsuario(Usuario usuario) {this.usuario = usuario;}
	
	//---
	
	public void crearPanel() {		
		tNombre = new JTextField();
		tNombre.setBorder(BorderFactory.createTitledBorder("Nombre: "));
		tNombre.setBackground(null);
		
		pPass = new JPasswordField();
		pPass.setBorder(BorderFactory.createTitledBorder("Contraseña: "));
		pPass.setBackground(null);
		
		bConfirm = new JButton("Confirmar");
		bConfirm.setBackground(Color.GREEN);
		bConfirm.setActionCommand(Controlador.CONFIRMAR);
		bConfirm.addActionListener(this);
		
		bCancel = new JButton("Cancelar");
		bCancel.setBackground(Color.RED);
		bCancel.setActionCommand(Controlador.CANCELAR);
		bCancel.addActionListener(this);
		
		panel.add(tNombre);
		panel.add(bConfirm);
		panel.add(pPass);
		panel.add(bCancel);
	}
	
	//-----

	public JPanel getPanel() {return panel;}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch(comando) {
		case Controlador.CONFIRMAR:
			conector.firePropertyChange(Controlador.CONFIRMAR,null,new Usuario(3,tNombre.getText(),pPass.getText()));
			break;
		case Controlador.CANCELAR:
			conector.firePropertyChange(Controlador.CANCELAR, false, true);
			break;
		default:
		}
	}
}
