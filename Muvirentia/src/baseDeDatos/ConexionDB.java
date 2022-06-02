package baseDeDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {

	private Connection conexion;
	private Statement st;
	private ResultSet resultado;

	final static String PUERTO = "jdbc:mysql://localhost:3306/";
	final static String NOMBRE_BASE_DE_DATOS="Muvirentia";
	final static String CONEXION_BASE_DE_DATOS=PUERTO+NOMBRE_BASE_DE_DATOS;
	final static String USUARIO = "root";
	final static String CONTRASENIA = "12345678aA@";

	String query;

	public ConexionDB() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(CONEXION_BASE_DE_DATOS, USUARIO, CONTRASENIA);
			st = conexion.createStatement();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void getUsuario() {
		
		try {

			query = "select * from mysql.user";
			resultado = st.executeQuery(query);
			while (resultado.next()) {
				
				String nombrePlanta = resultado.getString("User");
				String pass=resultado.getString("authentication_string");
				System.out.println("PlantaID: " + nombrePlanta + "\nNombre de la planta: " + pass);
				System.out.println("----------------------");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
		
	}
	
	public void setDatos(String tabla, String nombrePlanta, String especie, String humedad) {
		query = "insert into " + tabla + " (nombre,especie,condicion) values ('" + nombrePlanta + "' ,'" + especie
				+ "' ,'" + humedad + "')";

		try {
			st.executeUpdate(query);
			System.out.println("Usuario agregado");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void getPlanta() {

		try {

			query = "select * from planta";
			resultado = st.executeQuery(query);
			while (resultado.next()) {
				int plantaID = resultado.getInt("plantaID");
				String nombrePlanta = resultado.getString("nombre");
				System.out.println("PlantaID: " + plantaID + "\nNombre de la planta: " + nombrePlanta);
				System.out.println("----------------------");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void getCondiciones() {

		try {

			query = "select * from condiciones";
			resultado = st.executeQuery(query);
			while (resultado.next()) {
				int condicionID = resultado.getInt("condicionID");
				String descripcion = resultado.getString("descripcion");
				Date temporada=resultado.getDate("tempodara");
				int humedad=resultado.getInt("humedadHambienteIdeal");
				float litrosAgua=resultado.getFloat("litrosMediaIdeal");
				int temperatura=resultado.getInt("temperaturaIdeal");
				int luz=resultado.getInt("nivelLuzIdeal");
				int plantaID=resultado.getInt("plantaID");
				System.out.println("PlantaID: " + plantaID + "\nCondicionID: " + condicionID+"\nDescripcion: "+descripcion+
						"\nFecha ideal: "+temporada+"\nHumedad ideal: "+humedad+ "\nLitros de agua diario: "+litrosAgua+
						" \nTemperatura ideal: "+temperatura+"\nLuz ideal: "+luz);
				System.out.println("----------------------");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void getPlantaTieneCondicion() {
		try {
			query = "select * from tiene";
			resultado = st.executeQuery(query);
			while (resultado.next()) {
				int plantaID = resultado.getInt("plantaID");
				int condicionID = resultado.getInt("condicionID");
				System.out.println("PlantaID: " + plantaID + "\nCondicionID " + condicionID);
				System.out.println("----------------------");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void getInvernadero() {
		
		try {

			query = "select * from invernadero";
			resultado = st.executeQuery(query);
			while (resultado.next()) {
				int invernaderoID = resultado.getInt("invernaderoID");
				String descripcion = resultado.getString("descripcion");
				int areaCultivable=resultado.getInt("areaCultivo");
				System.out.println("Invernadero ID: " + invernaderoID + "\nDescripcion: " + descripcion+"\nArea total:"+areaCultivable);
				System.out.println("----------------------");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	public void getPlantaHaberInvernadero() {

		try {

			query = "select * from haber";
			resultado = st.executeQuery(query);
			while (resultado.next()) {
				int cantidad = resultado.getInt("cantidad");
				Date fechaPlantado = resultado.getDate("fechaPlantado");
				int plantaID=resultado.getInt("plantaID");
				int invernaderoID=resultado.getInt("invernaderoID");
				System.out.println("PlantaID: "+plantaID+"\nInvernaderoID: "+invernaderoID+"\nCantidad: " + cantidad + "\nFecha de plantacion: " + fechaPlantado);
				System.out.println("----------------------");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void getPropietario() {
		
		try {

			query = "select * from propietario";
			resultado = st.executeQuery(query);
			while (resultado.next()) {
				int propietarioID = resultado.getInt("propietarioID");
				String nombre = resultado.getString("nombre");
				int invernaderoID=resultado.getInt("invernaderoID");
				System.out.println("Invernadero ID: " + invernaderoID + "\nPropietarioID: " + propietarioID+"\nNombre:"+nombre);
				System.out.println("----------------------");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
		
	public void getCuidar() {

		try {

			query = "select * from cuidar";
			resultado = st.executeQuery(query);
			while (resultado.next()) {
				int propietarioID = resultado.getInt("propietarioID");
				int plantaID = resultado.getInt("plantaID");
				int invernaderoID=resultado.getInt("invernaderoID");
				System.out.println("Invernadero ID: " + invernaderoID + "\nPropietarioID: " + propietarioID+"\nPlantaID: "+plantaID);
				System.out.println("----------------------");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void close() {

		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
