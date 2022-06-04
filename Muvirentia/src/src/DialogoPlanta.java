package src;

import javax.swing.*;


import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DialogoPlanta extends JDialog implements ActionListener {

    JButton bAceptar, bCancelar;
    JLabel lbPlantaID, lbNombre, lbEspecieNombre, lbEspecieID, lbCondicionID, lbDescripcionCondicion, lbTemporada,
            lbHumedad, lbLitros,
            lbTemperatura, lbLuz, lbFechaPlantado, lbPlantaCantidad, lbInvernaderoID, lbDescripcionInvernadero,
            lbAreaCultivable,
            lbNombrePropietario, lbPropietarioID;
    JTextField tfPlantaID, tfNombre, tfEspecieNombre, tfEspecieID, tfCondicionID, tfDescripcionCondicion, tfTemporada,
            tfHumedad,
            tfLitros, tfTemperatura, tfLuz, tfFechaPlantado, tfPlantaCantidad, tfInvernaderoID,
            tfDescripcionInvernadero, tfAreaCultivable,
            tfNombrePropietario, tfPropietarioID;
    FormularioAniadir formulario;

    // Constructor
    public DialogoPlanta(JFrame ventana, String titulo, boolean modo) {
        super(ventana, titulo, modo);
        this.setSize(500, 1000);
        this.setLocation(600, 25);



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

        JPanel panel = new JPanel(new GridLayout(18, 2, 0, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        tfPlantaID = new JTextField();
        tfNombre = new JTextField();
        tfEspecieNombre = new JTextField();
        tfEspecieID = new JTextField();
        tfCondicionID = new JTextField();
        tfDescripcionCondicion = new JTextField();
        tfTemporada = new JTextField();
        tfHumedad = new JTextField();
        tfLitros = new JTextField();
        tfTemperatura = new JTextField();
        tfLuz = new JTextField();
        tfFechaPlantado = new JTextField();
        tfPlantaCantidad = new JTextField();
        tfInvernaderoID = new JTextField();
        tfDescripcionInvernadero = new JTextField();
        tfAreaCultivable = new JTextField();
        tfNombrePropietario = new JTextField();
        tfPropietarioID = new JTextField();
/*/
        tfNombrePropietario.addKeyListener(new KeyA(){
            
            public void keyTyped(KeyEvent e) {
                if (tfNombrePropietario.getText().length() >= 10) {
                    e.consume();
                }
            }
        });
   */

        lbPlantaID = new JLabel("Planta ID: ");
        lbNombre = new JLabel("Nombre de la planta: ");
        lbEspecieNombre = new JLabel("Nombre del especie : ");
        lbEspecieID = new JLabel("Especie ID: ");
        lbCondicionID = new JLabel("Condicion ID: ");
        lbDescripcionCondicion = new JLabel("Descripcion para la condicion: ");
        lbTemporada = new JLabel("Temporada optima: ");
        lbHumedad = new JLabel("Humedad optima: ");
        lbLitros = new JLabel("Litros de agua optima: ");
        lbTemperatura = new JLabel("Temperatura optima: ");
        lbLuz = new JLabel("Luz optima: ");
        lbFechaPlantado = new JLabel("Fecha plantado: ");
        lbPlantaCantidad = new JLabel("Cantidad plantado: ");
        lbInvernaderoID = new JLabel("Invernadero ID: ");
        lbDescripcionInvernadero = new JLabel("Descripcion del invernadero: ");
        lbAreaCultivable = new JLabel("Area Cultivable: ");
        lbPropietarioID = new JLabel("Propietario ID: ");
        lbNombrePropietario = new JLabel("Nombre del propietario: ");


        panel.add(lbPlantaID);
        panel.add(tfPlantaID);
        panel.add(lbNombre);
        panel.add(tfNombre);
        panel.add(lbEspecieNombre);
        panel.add(tfEspecieNombre);
        panel.add(lbEspecieID);
        panel.add(tfEspecieID);
        panel.add(lbCondicionID);
        panel.add(tfCondicionID);
        panel.add(lbDescripcionCondicion);
        panel.add(tfDescripcionCondicion);
        panel.add(lbTemporada);
        panel.add(tfTemporada);
        panel.add(lbHumedad);
        panel.add(tfHumedad);
        panel.add(lbLitros);
        panel.add(tfLitros);
        panel.add(lbTemperatura);
        panel.add(tfTemperatura);
        panel.add(lbLuz);
        panel.add(tfLuz);
        panel.add(lbFechaPlantado);
        panel.add(tfFechaPlantado);
        panel.add(lbPlantaCantidad);
        panel.add(tfPlantaCantidad);
        panel.add(lbInvernaderoID);
        panel.add(tfInvernaderoID);
        panel.add(lbDescripcionInvernadero);
        panel.add(tfDescripcionInvernadero);
        panel.add(lbAreaCultivable);
        panel.add(tfAreaCultivable);
        panel.add(lbPropietarioID);
        panel.add(tfPropietarioID);
        panel.add(lbNombrePropietario);
        panel.add(tfNombrePropietario);

        
        return panel;
    }

    private Component crearPanelBotones() {
        JPanel panel = new JPanel();
        bAceptar = new JButton("Aceptar");
        bAceptar.setActionCommand("Aceptar");
        bAceptar.addActionListener(this);

        bCancelar = new JButton("Cancelar");
        bCancelar.setActionCommand("Cancelar");
        bCancelar.addActionListener(this);

        panel.add(bAceptar);
        panel.add(bCancelar);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
		switch (comando) {
		case "Aceptar":
			
			this.dispose();
			break;
		case "Cancelar":
			formulario=null;
			this.dispose();
			break;
		default:

		}
    }

    public FormularioAniadir getFormulario() {
        return formulario;
    }

}
