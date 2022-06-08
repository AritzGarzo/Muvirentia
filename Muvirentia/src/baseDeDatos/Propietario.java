package baseDeDatos;

public class Propietario {
    
    int propietarioID;
    String nombre;
   

    public Propietario(int propietarioID, String nombre, int inventarioID) {
        this.propietarioID = propietarioID;
        this.nombre = nombre;

    }

    public int getPropietarioID() {
        return propietarioID;
    }

    public String getNombre() {
        return nombre;
    }



    public void setPropietarioID(int propietarioID) {
        this.propietarioID = propietarioID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   


}
