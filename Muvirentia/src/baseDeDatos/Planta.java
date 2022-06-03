package baseDeDatos;

public class Planta {
    int plantaID;
    String nombre;

    public Planta(int id, String nombre) {
        this.plantaID = id;
        this.nombre = nombre;
    }

    public int getId() {
        return plantaID;
    }
    public String getNombre() {
         return nombre;
    }

    public void setId(int id) {
        this.plantaID = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

