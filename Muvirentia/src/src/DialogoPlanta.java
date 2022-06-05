package src;

import javax.swing.*;

import baseDeDatos.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DialogoPlanta extends JDialog implements ActionListener {

    JButton bAceptar, bCancelar;
    JLabel lbPlantaID, lbNombre, lbEspecieNombre, lbEspecieID, lbCondicionID, lbDescripcionCondicion, lbTemporada,
            lbHumedad, lbLitros,
            lbTemperatura, lbLuz, lbFechaPlantado, lbPlantaCantidad, lbInvernaderoID, lbDescripcionInvernadero,
            lbAreaCultivable,
            lbNombrePropietario, lbPropietarioID;
    JTextField tfPlantaID, tfNombre, tfEspecieNombre, tfEspecieID, tfCondicionID, tfDescripcionCondicion, tfTemporada,
            tfHumedad, tfLitros, tfTemperatura, tfLuz, tfFechaPlantado, tfPlantaCantidad, tfInvernaderoID,
            tfDescripcionInvernadero, tfAreaCultivable, tfNombrePropietario, tfPropietarioID;

    FormularioAniadir formulario;

    ConexionDB conexion;

    Planta planta;
    Condiciones condicion;
    Cuidar cuidar;
    Propietario propietario;
    Haber haber;
    Especie especie;
    Invernadero invernadero;
    Tiene tiene;

    // Constructor
    public DialogoPlanta(JFrame ventana, String titulo, boolean modo) {
        super(ventana, titulo, modo);
        this.setSize(500, 1000);
        this.setLocation(600, 25);
        conexion = new ConexionDB();
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
        /*
         * /
         * tfNombrePropietario.addKeyListener(new KeyA(){
         * 
         * public void keyTyped(KeyEvent e) {
         * if (tfNombrePropietario.getText().length() >= 10) {
         * e.consume();
         * }
         * }
         * });
         */

        lbPlantaID = new JLabel("Planta ID: ");
        lbNombre = new JLabel("Nombre de la planta: ");
        lbEspecieNombre = new JLabel("Nombre del especie : ");
        lbEspecieID = new JLabel("Especie ID: ");
        lbCondicionID = new JLabel("Condicion ID: ");
        lbDescripcionCondicion = new JLabel("Descripcion para la condicion: ");
        lbTemporada = new JLabel("Temporada optima (yyyy-mm-dd): ");
        lbHumedad = new JLabel("Humedad optima: ");
        lbLitros = new JLabel("Litros de agua optima: ");
        lbTemperatura = new JLabel("Temperatura optima: ");
        lbLuz = new JLabel("Luz optima: ");
        lbFechaPlantado = new JLabel("Fecha plantado (yyyy-mm-dd): ");
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
                if (campoVacio()) {
                    int opcion = JOptionPane.showConfirmDialog(null,
                            "Debe completar todos los campos, desea borrar datos introducidos?", "Error",
                            JOptionPane.YES_NO_OPTION);

                    if (opcion == 0) {
                        borrarTextoIntroducidos();
                    }

                } else {

                    crearFormularioDeLosDatos();
                    // insertBaseDeDatos(planta, condicion, tiene, especie, haber, invernadero,
                    // propietario, cuidar);
                    this.dispose();
                }
                break;
            case "Cancelar":
                int opcion = JOptionPane.showConfirmDialog(null, "Hay cambios sin guardar, seguro que quiere cancelar?",
                        "Error", JOptionPane.YES_NO_OPTION);
                if (opcion == 0) {
                    this.dispose();
                    formulario = null;
                }
                break;
            default:

        }
    }

    private void crearFormularioDeLosDatos() {

        planta = new Planta(Integer.parseInt(tfPlantaID.getText()), tfNombre.getText());
        condicion = new Condiciones(Integer.parseInt(tfCondicionID.getText()),
                tfDescripcionCondicion.getText(), Date.valueOf(tfTemporada.getText()),
                Integer.parseInt(tfHumedad.getText()), Float.parseFloat(tfLitros.getText()),
                Integer.parseInt(tfTemperatura.getText()), Integer.parseInt(tfLuz.getText()),
                Integer.parseInt(tfPlantaID.getText()));
        tiene = new Tiene(Integer.parseInt(tfPlantaID.getText()),
                Integer.parseInt(tfCondicionID.getText()));
        especie = new Especie(Integer.parseInt(tfEspecieID.getText()), tfEspecieNombre.getText(),
                Integer.parseInt(tfPlantaID.getText()));
        haber = new Haber(Date.valueOf(tfFechaPlantado.getText()),
                Integer.parseInt(tfPlantaCantidad.getText()), Integer.parseInt(tfPlantaID.getText()),
                Integer.parseInt(tfInvernaderoID.getText()));
        invernadero = new Invernadero(Integer.parseInt(tfInvernaderoID.getText()),
                tfDescripcionInvernadero.getText(), Integer.parseInt(tfAreaCultivable.getText()));
        propietario = new Propietario(Integer.parseInt(tfPropietarioID.getText()),
                tfNombrePropietario.getText(), Integer.parseInt(tfInvernaderoID.getText()));
        cuidar = new Cuidar(Integer.parseInt(tfPlantaID.getText()),
                Integer.parseInt(tfInvernaderoID.getText()), Integer.parseInt(tfPropietarioID.getText()));
        formulario = new FormularioAniadir(planta, invernadero, tiene, cuidar, condicion, propietario,
                haber, especie);
    }

    private boolean campoVacio() {
        if (tfPlantaID.getText().isEmpty() || tfInvernaderoID.getText().isEmpty()
                || tfPropietarioID.getText().isEmpty() || tfFechaPlantado.getText().isEmpty() ||
                tfEspecieID.getText().isEmpty() || tfCondicionID.getText().isEmpty() || tfTemporada.getText().isEmpty()
                || tfHumedad.getText().isEmpty() ||
                tfLitros.getText().isEmpty() || tfTemperatura.getText().isEmpty() || tfLuz.getText().isEmpty()
                || tfPlantaCantidad.getText().isEmpty() ||
                tfDescripcionCondicion.getText().isEmpty() || tfDescripcionInvernadero.getText().isEmpty()
                || tfAreaCultivable.getText().isEmpty() ||
                tfNombre.getText().isEmpty() || tfEspecieNombre.getText().isEmpty()
                || tfNombrePropietario.getText().isEmpty())
            return true;
        else
            return false;

    }

    private void insertBaseDeDatos(Planta planta2, Condiciones condicion2, Tiene tiene2, Especie especie2, Haber haber2,
            Invernadero invernadero2, Propietario propietario2, Cuidar cuidar2) {

        conexion.setPlanta(planta2);
        conexion.setInvernadero(invernadero2);
        conexion.setPropietario(propietario2, invernadero2);
        conexion.setCondicion(condicion2, planta2);
        conexion.setTiene(tiene2);
        conexion.setEspecie(especie2, planta2);
        conexion.setHaber(haber2);
        conexion.setCuidar(cuidar2);
    }

    private void borrarTextoIntroducidos() {
        tfPlantaID.setText("");
        tfNombre.setText("");
        tfEspecieNombre.setText("");
        tfEspecieID.setText("");
        tfCondicionID.setText("");
        tfDescripcionCondicion.setText("");
        tfTemporada.setText("");
        tfHumedad.setText("");
        tfLitros.setText("");
        tfTemperatura.setText("");
        tfLuz.setText("");
        tfFechaPlantado.setText("");
        tfPlantaCantidad.setText("");
        tfInvernaderoID.setText("");
        tfDescripcionInvernadero.setText("");
        tfAreaCultivable.setText("");
        tfPropietarioID.setText("");
        tfNombrePropietario.setText("");
    }

    public FormularioAniadir getFormulario() {
        return formulario;
    }

}
