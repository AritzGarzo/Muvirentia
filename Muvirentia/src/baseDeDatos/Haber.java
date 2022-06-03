package baseDeDatos;

import java.sql.Date;

public class Haber {

    Date fechaPlantado;
    int cantidad;
    int plantaID;
    int inventarioID;

    public Haber(Date fechaPlantado, int cantidad, int plantaID, int inventarioID) {
        this.fechaPlantado = fechaPlantado;
        this.cantidad = cantidad;
        this.plantaID = plantaID;
        this.inventarioID = inventarioID;
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

    public int getInventarioID() {
        return inventarioID;
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

    public void setInventarioID(int inventarioID) {
        this.inventarioID = inventarioID;
    }

    
}
