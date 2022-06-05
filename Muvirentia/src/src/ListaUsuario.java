package src;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuario {
	List<Usuario> lista;
	public ListaUsuario() {
		lista= new ArrayList<>();
	}
	
	public List<Usuario> getLista(){return lista;}
	
	public int validarUsuario() {
		//se valida el usuario
		// devuelve -1 si no es validado
		// devuelve su ID si esta validado
		return 3;
	}
	
	/*public void setListaUsuarios(Usuario usuario) {
		//recoger usuarios desde la base de datos
	}*/
}
