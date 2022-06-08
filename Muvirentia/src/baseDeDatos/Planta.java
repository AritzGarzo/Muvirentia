package baseDeDatos;

public class Planta {
    int plantaID;
    String nombre;
    int especieID;

    public Planta(int id, String nombre, int especieID) {
        this.plantaID = id;
        this.nombre = nombre;
        this.especieID = especieID;
    }

    public int getId() {
        return plantaID;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEspecie() {
        return especieID;
    }

    public void setEspecie(int especieID) {
        this.especieID = especieID;
    }

    public void setId(int id) {
        this.plantaID = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
