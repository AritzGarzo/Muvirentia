package baseDeDatos;

public class Tiene {

    int plantaID;
    int condicionID;

    //Constructor
    public Tiene(int plantaID, int condicionID) {
        this.plantaID = plantaID;
        this.condicionID = condicionID;
    }

    //Getters
    public int getPlantaID() {
        return plantaID;
    }
    public int getCondicionID() {
        return condicionID;
    }

    //Setters
    public void setPlantaID(int plantaID) {
        this.plantaID = plantaID;
    }
    public void setCondicionID(int condicionID) {
        this.condicionID = condicionID;
    }

}
