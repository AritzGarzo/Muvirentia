package pantallas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import principal.Controlador;

public class PanelGrafico extends JFrame {
	Controlador controlador;
	public PanelGrafico(Controlador controlador) {
		this.controlador = controlador;
		JOptionPane.showConfirmDialog(this,"Todavía no se ha implementado este incremento.",
				"Elemento por incrementar",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
	}
}
