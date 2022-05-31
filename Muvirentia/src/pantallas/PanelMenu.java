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

public class PanelMenu extends JFrame implements PropertyChangeListener {
//	private final static String FICHERO_FORMULARIOS = "formularios.dat";
	Controlador controlador;
	JPanel panel;
	JButton bHome, bFormulario, bGrafico, bAddPlanta, bDelPlanta, bSistema;
	JList<Formulario> jlFormularios;
	List<Formulario> lFormularios;
	boolean sistema=false;//true = sistema encendido | false = sistema apagado

	public PanelMenu(Controlador controlador) {
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
		bHome.setActionCommand(Controlador.PANEL_PRINCIPAL);
		bHome.addActionListener(controlador);

		bFormulario = new JButton("Formulario");
		bFormulario.setActionCommand("formulario");
		bFormulario.addActionListener(controlador);

		bGrafico = new JButton("Grafico");
		bGrafico.setActionCommand(Controlador.PANEL_GRAFICO);
		bGrafico.addActionListener(controlador);

		bAddPlanta = new JButton("Añadir planta");
		bAddPlanta.setActionCommand(Controlador.ADD_PLANTA);
		bAddPlanta.addActionListener(controlador);

		bDelPlanta = new JButton("Eliminar planta");
		bDelPlanta.setActionCommand(Controlador.DEL_PLANTA);
		bDelPlanta.addActionListener(controlador);

		bSistema = new JButton("Sistema");
		bSistema.setActionCommand(Controlador.SISTEMA);
		bSistema.addActionListener(controlador);

		panel.add(bHome);
		panel.add(Box.createHorizontalStrut(30));
		panel.add(bFormulario);
		panel.add(Box.createHorizontalStrut(30));
		panel.add(bGrafico);
		panel.add(Box.createHorizontalStrut(30));
		panel.add(bAddPlanta);
		panel.add(Box.createHorizontalStrut(30));
		panel.add(bDelPlanta);
		panel.add(Box.createHorizontalStrut(30));
		panel.add(bSistema);
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
		int opcion;
		switch(propiedad) {
		case Controlador.FORMULARIO:
			opcion = JOptionPane.showConfirmDialog(this,
					"Todavía no se puede enviar el formulario, pero se puede guardar", "Elemento por incrementar",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if (opcion == JOptionPane.OK_OPTION) {
				Formulario formulario = (Formulario) evt.getNewValue();
				lFormularios.add(formulario);
				jlFormularios.setListData(lFormularios.toArray(new Formulario[0]));
			}
			break;
		case Controlador.ADD_PLANTA:
			break;
		case Controlador.DEL_PLANTA:
			break;
		case Controlador.SISTEMA:
			opcion = JOptionPane.showConfirmDialog(this, ((sistema)?"¿Quieres apagar el sistema?":"¿Quieres encender el sistema?"),
					"Estado del sistema",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			if(sistema) {//sistema encendido
				if(opcion == JOptionPane.YES_OPTION) {
					sistema = false;
				}
			} else {//sistema apagado
				if(opcion==JOptionPane.YES_OPTION) {
					sistema = true;
				}
			}
			break;
		default:
		}
	}
}
