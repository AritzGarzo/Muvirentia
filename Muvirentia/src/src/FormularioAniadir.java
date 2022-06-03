package src;

import baseDeDatos.*;

public class FormularioAniadir {

    Planta planta;
    Invernadero invernadero;
    Tiene tiene;
    Cuidar cuidar;
    Condiciones condicion;
    Propietario propietario;
    Haber haber;
    Especie especie;

    //constructor
    public FormularioAniadir(Planta planta, Invernadero invernadero, Tiene tiene, Cuidar cuidar, Condiciones condicion, Propietario propietario, Haber haber, Especie especie) {
        this.planta = planta;
        this.invernadero = invernadero;
        this.tiene = tiene;
        this.cuidar = cuidar;
        this.condicion = condicion;
        this.propietario = propietario;
        this.haber = haber;
        this.especie = especie;
    }

    //getters
    public Planta getPlanta() {
        return planta;
    }

    public Invernadero getInvernadero() {
        return invernadero;
    }

    public Tiene getTiene() {
        return tiene;
    }

    public Cuidar getCuidar() {
        return cuidar;
    }

    public Condiciones getCondicion() {
        return condicion;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public Haber getHaber() {
        return haber;
    }

    public Especie getEspecie() {
        return especie;
    }

    //setters  
    public void setPlanta(Planta planta) {
        this.planta = planta;
    }   

    public void setInvernadero(Invernadero invernadero) {
        this.invernadero = invernadero;
    }

    public void setTiene(Tiene tiene) {
        this.tiene = tiene;
    }

    public void setCuidar(Cuidar cuidar) {
        this.cuidar = cuidar;
    }

    public void setCondicion(Condiciones condicion) {
        this.condicion = condicion;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public void setHaber(Haber haber) {
        this.haber = haber;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    
}
