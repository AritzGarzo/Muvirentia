package baseDeDatos;

public class Cuidar {
        
        int invernaderoID;
        int plantaID;
        int propietarioID;

        public Cuidar(int invernaderoID, int plantaID, int propietarioID) {
            this.invernaderoID = invernaderoID;
            this.plantaID = plantaID;
            this.propietarioID = propietarioID;
        }

        public int getInvernaderoID() {
            return invernaderoID;
        }

        public int getPlantaID() {
            return plantaID;
        }

        public int getPropietarioID() {
            return propietarioID;
        }

        public void setInvernaderoID(int invernaderoID) {
            this.invernaderoID = invernaderoID;
        }

        public void setPlantaID(int plantaID) {
            this.plantaID = plantaID;
        }

        public void setPropietarioID(int propietarioID) {
            this.propietarioID = propietarioID;
        }

        
}
