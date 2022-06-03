package src;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoPlanta extends JDialog implements ActionListener{

    JButton bAceptar, bCancelar;
    JLabel lbNombre, lbDescripcion;
    JTextField tNombre, tDescripcion;
    FormularioAniadir formulario;

    // Constructor
    public DialogoPlanta(JFrame ventana, String titulo, boolean modo) {
        super(ventana, titulo, modo);
        this.setSize(500, 600);
        this.setLocation(600, 100);
        this.setContentPane(crearPanelDialog());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private Container crearPanelDialog() {
        JPanel panel = new JPanel(new BorderLayout(0, 20));
		panel.add(crearPanelCentral(), BorderLayout.CENTER);
		panel.add(crearPanelBotones(), BorderLayout.SOUTH);
		return panel;
    }

    private Component crearPanelCentral() {
        
        JPanel panel = new JPanel(new GridLayout(4, 1, 0, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return panel;
    }

    private Component crearPanelBotones() {
        JPanel panel = new JPanel();
		bAceptar = new JButton("Aceptar");
		bAceptar.setActionCommand("Aceptar");
		bAceptar.addActionListener(this);

		bCancelar = new JButton("Cancelar");
		bCancelar.setActionCommand("cancelar");
		bCancelar.addActionListener(this);

		panel.add(bAceptar);
		panel.add(bCancelar);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    public FormularioAniadir getFormulario() {return formulario;}

    
}
