package baseDeDatos;

public class Propietario {
    
    int propietarioID;
    String nombre;
    int inventarioID;

    public Propietario(int propietarioID, String nombre, int inventarioID) {
        this.propietarioID = propietarioID;
        this.nombre = nombre;
        this.inventarioID = inventarioID;
    }

    public int getPropietarioID() {
        return propietarioID;
    }

    public String getNombre() {
        return nombre;
    }

    public int getInventarioID() {
        return inventarioID;
    }

    public void setPropietarioID(int propietarioID) {
        this.propietarioID = propietarioID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   

    public void setInventarioID(int inventarioID) {
        this.inventarioID = inventarioID;
    }
}
