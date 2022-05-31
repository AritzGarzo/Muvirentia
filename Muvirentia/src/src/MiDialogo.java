package src;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MiDialogo extends JDialog implements ActionListener {
	JButton bSend, bCancel;
	JLabel lbNombre, lbDescripcion;
	JTextField tNombre, tDescripcion;
	Formulario formulario;
	JRadioButton rSi,rSensores,rValvula;

	public MiDialogo(JFrame ventana, String titulo, boolean modo) {
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

		tNombre = new JTextField();
		tNombre.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Nombre"),
				BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(20, 20, 20, 20))));
		tNombre.setBackground(null);
		panel.add(tNombre);
		// -------
		tDescripcion = new JTextField();
		tDescripcion.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Descripcion"),
				BorderFactory.createLoweredBevelBorder()));
		tDescripcion.setBackground(null);
		panel.add(tDescripcion);
		// -------
		JPanel pIntento = new JPanel();
		pIntento.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Se ha intentado arreglar?"),
						BorderFactory.createLoweredBevelBorder()));
		pIntento.setBackground(null);

		ButtonGroup bgIntento = new ButtonGroup();
		rSi = new JRadioButton("Si");
		rSi.setSelected(false);

		JRadioButton rNo = new JRadioButton("No");
		rNo.setSelected(true);
		bgIntento.add(rSi);
		bgIntento.add(rNo);

		pIntento.add(rSi);
		pIntento.add(rNo);
		panel.add(pIntento);
		// -------
		JPanel pInvolucra = new JPanel();
		pInvolucra.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("¿Qué elementos involucra?"),
						BorderFactory.createLoweredBevelBorder()));
		pInvolucra.setBackground(null);

		ButtonGroup bgInvolucra = new ButtonGroup();
		rSensores = new JRadioButton("Sensores");
		rSensores.setSelected(false);
		rValvula = new JRadioButton("Valvula");
		rValvula.setSelected(true);

		pInvolucra.add(rSensores);
		pInvolucra.add(rValvula);
		panel.add(pInvolucra);

		return panel;
	}

	private Component crearPanelBotones() {
		JPanel panel = new JPanel();
		bSend = new JButton("Enviar");
		bSend.setActionCommand("enviar");
		bSend.addActionListener(this);

		bCancel = new JButton("Cancelar");
		bCancel.setActionCommand("cancelar");
		bCancel.addActionListener(this);

		panel.add(bSend);
		panel.add(bCancel);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
		case "enviar":
			formulario = new Formulario(tNombre.getText(),tDescripcion.getText(),rSi.isSelected(),
					rSensores.isSelected(),rValvula.isSelected());
			this.dispose();
			break;
		case "cancelar":
			formulario=null;
			this.dispose();
			break;
		default:

		}
	}
	
	public Formulario getFormulario() {return formulario;}
}
