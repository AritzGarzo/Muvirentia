package baseDeDatos;

public class Invernadero {
        
     int invernaderoID;
     String descripcion;
     int areaCultivo;

        public Invernadero(int invernaderoID, String descripcion, int areaCultivo) {
            this.invernaderoID = invernaderoID;
            this.descripcion = descripcion;
            this.areaCultivo = areaCultivo;
        }

        public int getInvernaderoID() {
            return invernaderoID;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public int getAreaCultivo() {
            return areaCultivo;
        }

        public void setInvernaderoID(int invernaderoID) {
            this.invernaderoID = invernaderoID;
        }   

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public void setAreaCultivo(int areaCultivo) {
            this.areaCultivo = areaCultivo;
        }   
        
  
}
