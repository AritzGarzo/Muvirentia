package pantallas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import principal.Controlador;
import src.Usuario;

public class PanelLogin extends JFrame implements ActionListener {
	private final static String NOMBRE="Investor",PASS="InvestToHelp";
	JPanel panel;
	JTextField tNombre;
	JPasswordField pPass;
	JButton bConfirm,bCancel;
	Usuario usuario;
	Controlador controlador;
	PropertyChangeSupport conector;
	
	public PanelLogin(Controlador controlador,Usuario usuario) {
		this.usuario = usuario;
		this.controlador = controlador;
		conector = new PropertyChangeSupport(this);
		conector.addPropertyChangeListener(controlador);
		
		panel = new JPanel(new GridLayout(2,2,60,60));
		crearPanel();
	}
	
	//---
	
	public void crearPanel() {		
		tNombre = new JTextField((usuario==null)?"":usuario.getNombre());
		tNombre.setBorder(BorderFactory.createTitledBorder("Nombre: "));
		tNombre.setBackground(null);
		
		pPass = new JPasswordField((usuario==null)?"":usuario.getContrasena());
		pPass.setBorder(BorderFactory.createTitledBorder("ContraseÃ±a: "));
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
			if(NOMBRE.equals(tNombre.getText()) && PASS.equals(pPass.getText())) {
				conector.firePropertyChange(Controlador.CONFIRMAR,null,new Usuario(1,tNombre.getText(),pPass.getText()));
			} else {
				int opcion = JOptionPane.showConfirmDialog(this,"Usuario o contraseña introducida incorrecta",
						"Información incorrecta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				tNombre.setText("");
				pPass.setText("");
			}
			break;
		case Controlador.CANCELAR:
			conector.firePropertyChange(Controlador.CANCELAR, false, true);
			break;
		default:
		}
	}
}
