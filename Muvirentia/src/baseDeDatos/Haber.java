package baseDeDatos;

import java.sql.Date;

public class Haber {

    Date fechaPlantado;
    int cantidad;
    int plantaID;
    int invernaderoID;

    public Haber(Date fechaPlantado, int cantidad, int plantaID, int invernaderoID) {
        this.fechaPlantado = fechaPlantado;
        this.cantidad = cantidad;
        this.plantaID = plantaID;
        this.invernaderoID = invernaderoID;
    }

    public Date getFechaPlantado() {
        return fechaPlantado;
    }


    public int getCantidad() {
        return cantidad;
    }

    public int getPlantaID() {
        return plantaID;
    }

    public int getInvernaderoID() {
        return invernaderoID;
    }

    public void setFechaPlantado(Date fechaPlantado) {
        this.fechaPlantado = fechaPlantado;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPlantaID(int plantaID) {
        this.plantaID = plantaID;
    }

    public void setInvernaderoID(int invernaderoID) {
        this.invernaderoID = invernaderoID;
    }

    
}
