package baseDeDatos;

import java.sql.Date;

public class Condiciones {
    int condicionID;
    String descripcion;
    Date temporada;
    int humedadIdeal;
    float litrosMediaIdeal;
    int temperaturaIdeal;
    int nivelLuzIdeal;
    int plantaID;

    //constructor
    public Condiciones(int condicionID, String descripcion, Date temporada, int humedadIdeal, float litrosMediaIdeal, int temperaturaIdeal, int nivelLuzIdeal, int plantaID) {
        this.condicionID = condicionID;
        this.descripcion = descripcion;
        this.temporada = temporada;
        this.humedadIdeal = humedadIdeal;
        this.litrosMediaIdeal = litrosMediaIdeal;
        this.temperaturaIdeal = temperaturaIdeal;
        this.nivelLuzIdeal = nivelLuzIdeal;
        this.plantaID = plantaID;
    }

    //getters
    public int getCondicionID() {
        return condicionID;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Date getTemporada() {
        return temporada;
    }
    public int getHumedadIdeal() {
        return humedadIdeal;
    }
    public float getLitrosMediaIdeal() {
        return litrosMediaIdeal;
    }
    public int getTemperaturaIdeal() {
        return temperaturaIdeal;
    }
    public int getNivelLuzIdeal() {
        return nivelLuzIdeal;
    }
    public int getPlantaID() {
        return plantaID;
    }

    //setters
    public void setCondicionID(int condicionID) {
        this.condicionID = condicionID;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setTemporada(Date temporada) {
        this.temporada = temporada;
    }
    public void setHumedadIdeal(int humedadIdeal) {
        this.humedadIdeal = humedadIdeal;
    }
    public void setLitrosMediaIdeal(float litrosMediaIdeal) {
        this.litrosMediaIdeal = litrosMediaIdeal;
    }
    public void setTemperaturaIdeal(int temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }
    public void setNivelLuzIdeal(int nivelLuzIdeal) {
        this.nivelLuzIdeal = nivelLuzIdeal;
    }
    public void setPlantaID(int plantaID) {
        this.plantaID = plantaID;
    }
    
    
}
