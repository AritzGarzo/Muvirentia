package baseDeDatos;

public class Especie {

    int especieID;
    String nombreEspecie;
    int plantaID;

    public Especie(int especieID, String nombreEspecie, int plantaID) {
        this.especieID = especieID;
        this.nombreEspecie = nombreEspecie;
        this.plantaID = plantaID;
    }
    //getters
    public int getEspecieID() {
        return especieID;
    }
    public String getNombreEspecie() {
        return nombreEspecie;
    }
    public int getPlantaID() {
        return plantaID;
    }
    //setters
    public void setEspecieID(int especieID) {
        this.especieID = especieID;
    }
    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }
    public void setPlantaID(int plantaID) {
        this.plantaID = plantaID;
    }
    
    
}
