package src;

import java.io.Serializable;

public class FormularioIncidencia implements Serializable {

	String nombre, descripcion;
	boolean intento, sensores, valvula;

	public FormularioIncidencia(String nombre, String descripcion, boolean intento, boolean sensores, boolean valvula) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.intento = intento;
		this.sensores = sensores;
		this.valvula = valvula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isIntento() {
		return intento;
	}

	public void setIntento(boolean intento) {
		this.intento = intento;
	}

	public boolean isSensores() {
		return sensores;
	}

	public void setSensores(boolean sensores) {
		this.sensores = sensores;
	}

	public boolean isValvula() {
		return valvula;
	}

	public void setValvula(boolean valvula) {
		this.valvula = valvula;
	}
	
	public int getPosPalabraX(String string,int palabra) {
		int cont=0;
		while(cont<string.length() && palabra > 0) {
			char letra = string.charAt(cont);
			if(letra==32) {//valor ascii de espacio
				palabra--;
			}
			cont++;
		}
		
		return cont;
	}
	
	public String toString() {
		return "\"" + nombre +"\""+" ->" + ((intento)?" Se ha intentado arreglar.":"")
				+ ((sensores)?" Involucra los sensores.":"") + ((valvula)?" Involucra la valvula.":"");
	}

}
