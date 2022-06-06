package pantallas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

import baseDeDatos.Backup;
import baseDeDatos.ConexionDB;

import principal.Controlador;
import src.FormularioAniadir;
import src.FormularioIncidencia;

public class PanelMenu extends JFrame implements PropertyChangeListener {
//	private final static String FICHERO_FORMULARIOS = "formularios.dat";
	Controlador controlador;
	JPanel panel;
	JButton bHome, bFormulario, bGrafico, bAddPlanta, bDelPlanta, bSistema;
	JList<FormularioIncidencia> jlFormularios;
	List<FormularioIncidencia> lFormularios;
	JList<FormularioAniadir> jlPlantas;
	List<FormularioAniadir> lPlantas;
	boolean sistema=false;//true = sistema encendido | false = sistema apagado
	ConexionDB conexionDB;
	Backup backup;

	public PanelMenu(Controlador controlador) {
		this.controlador = controlador;
		lFormularios = new ArrayList<>();
		lPlantas = new ArrayList<>();
		controlador.addListener(this);
		conexionDB=new ConexionDB();
		backup=new Backup();

		// definir como se ve el panel
		panel = new JPanel(new BorderLayout(0, 10));
		panel.add(crearPanelNorte(), BorderLayout.NORTH);
		panel.add(crearPanelCentro(), BorderLayout.CENTER);

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

		bAddPlanta = new JButton("Aniadir planta");
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


	private Component crearPanelCentro() {
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split.setDividerLocation(250);
		split.add(crearPanelListaPlantas());
		split.add(crearPanelListaFormularios());
		return split;
	}
	

	private Component crearPanelListaPlantas() {
		JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		jlPlantas = new JList<>();
//		jlPlantas.setListData(lPlantas.toArray(new Planta[0]));
//		jlPlantas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//		scroll.setViewportView(jlPlantas);
		return scroll;
	}

	private Component crearPanelListaFormularios() {
		JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jlFormularios = new JList<>();
		jlFormularios.setListData(lFormularios.toArray(new FormularioIncidencia[0]));
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
					"Todavia no se puede enviar el formulario, pero se puede guardar", "Elemento por incrementar",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if (opcion == JOptionPane.OK_OPTION) {
				FormularioIncidencia formulario = (FormularioIncidencia) evt.getNewValue();
				lFormularios.add(formulario);
				jlFormularios.setListData(lFormularios.toArray(new FormularioIncidencia[0]));
			}
			break;
		case Controlador.ADD_PLANTA:
			FormularioAniadir formularioAniadir=(FormularioAniadir)evt.getNewValue();
			lPlantas.add(formularioAniadir);
			//jlPlantas.setListData(lPlantas.toArray(new formularioAniadir[0]));
			break;
		case Controlador.DEL_PLANTA:
			//delete en base de datos
			String resultado=JOptionPane.showInputDialog("ID de la planta que desea eliminar: ");
			conexionDB.eliminarPlanta(resultado);
			break;
		case Controlador.SISTEMA:
			opcion = JOptionPane.showConfirmDialog(this, ((sistema)?"¿Quieres apagar el sistema?":"¿Quieres encender el sistema?"),
					"Estado del sistema",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				try {
					backup.backupSql();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
