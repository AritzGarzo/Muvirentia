package baseDeDatos;

public class Invernadero {
        
     int invernaderoID;
     String descripcion;
     int areaCultivo;
     int propietarioID;

        public Invernadero(int invernaderoID, String descripcion, int areaCultivo,int propietario) {
            this.invernaderoID = invernaderoID;
            this.descripcion = descripcion;
            this.areaCultivo = areaCultivo;
            this.propietarioID=propietario;
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

        public int getPropietario() {
            return propietarioID;
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

        public void setPropietarioID(int propietarioID) {
            this.propietarioID = propietarioID;
        } 
  
}
