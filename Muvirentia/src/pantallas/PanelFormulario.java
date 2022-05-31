package pantallas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import principal.Controlador;
import src.Formulario;

public class PanelFormulario extends JFrame implements PropertyChangeListener {
	Controlador controlador;
	JPanel panel;
	JButton bHome, bMenu, bFormulario;
	JList<Formulario> jlFormularios;
	List<Formulario> lFormularios;

	public PanelFormulario(Controlador controlador) {
		this.controlador = controlador;
		lFormularios = new ArrayList<>();
		controlador.addListener(this);

		// definir como se ve el panel
		panel = new JPanel(new BorderLayout(0, 10));
		panel.add(crearPanelNorte(), BorderLayout.NORTH);
		panel.add(crearPanelLista(), BorderLayout.CENTER);

	}

	private Component crearPanelNorte() {
		JPanel panel = new JPanel();
		// botones
		bHome = new JButton("Home");
		bHome.setActionCommand("home");
		bHome.addActionListener(controlador);

		bMenu = new JButton("Menu");
		bMenu.setActionCommand("menu");
		bMenu.addActionListener(controlador);

		bFormulario = new JButton("Formulario");
		bFormulario.setActionCommand("formulario");
		bFormulario.addActionListener(controlador);

		panel.add(bHome);
		panel.add(Box.createHorizontalGlue());
		panel.add(bFormulario);
		panel.add(Box.createHorizontalStrut(30));
		panel.add(bMenu);
		return panel;
	}

	private Component crearPanelLista() {
		JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jlFormularios = new JList<>();
		jlFormularios.setListData(lFormularios.toArray(new Formulario[0]));
		jlFormularios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scroll.setViewportView(jlFormularios);
		return scroll;
	}

	private void enviarFormulario() {
		// Por implementar
		// pero puedes guardarlo
	}

	public JPanel getPanel() {
		return panel;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propiedad = evt.getPropertyName();
		if (propiedad.equals(Controlador.FORMULARIO)) {
			int opcion = JOptionPane.showConfirmDialog(this,
					"Todavía no se puede enviar el formulario, pero se puede guardar", "Elemento por incrementar",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if (opcion == JOptionPane.OK_OPTION) {
				Formulario formulario = (Formulario) evt.getNewValue();
				lFormularios.add(formulario);
				jlFormularios.setListData(lFormularios.toArray(new Formulario[0]));
			}
		}
	}

}
