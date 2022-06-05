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
	final static String NOMBRE_BASE_DE_DATOS = "Muvirentia";
	final static String CONEXION_BASE_DE_DATOS = PUERTO + NOMBRE_BASE_DE_DATOS;
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

	/*
	 * / public void getUsuario() {
	 * 
	 * try {
	 * 
	 * query = "select * from mysql.user";
	 * resultado = st.executeQuery(query);
	 * while (resultado.next()) {
	 * 
	 * String nombrePlanta = resultado.getString("User");
	 * String pass=resultado.getString("authentication_string");
	 * System.out.println("PlantaID: " + nombrePlanta + "\nNombre de la planta: " +
	 * pass);
	 * System.out.println("----------------------");
	 * }
	 * 
	 * } catch (Exception ex) {
	 * ex.printStackTrace();
	 * }
	 * 
	 * 
	 * }
	 */

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
				Date temporada = resultado.getDate("tempodara");
				int humedad = resultado.getInt("humedadHambienteIdeal");
				float litrosAgua = resultado.getFloat("litrosMediaIdeal");
				int temperatura = resultado.getInt("temperaturaIdeal");
				int luz = resultado.getInt("nivelLuzIdeal");
				int plantaID = resultado.getInt("plantaID");
				System.out.println(
						"PlantaID: " + plantaID + "\nCondicionID: " + condicionID + "\nDescripcion: " + descripcion +
								"\nFecha ideal: " + temporada + "\nHumedad ideal: " + humedad
								+ "\nLitros de agua diario: " + litrosAgua +
								" \nTemperatura ideal: " + temperatura + "\nLuz ideal: " + luz);
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
				int areaCultivable = resultado.getInt("areaCultivo");
				System.out.println("Invernadero ID: " + invernaderoID + "\nDescripcion: " + descripcion
						+ "\nArea total:" + areaCultivable);
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
				int plantaID = resultado.getInt("plantaID");
				int invernaderoID = resultado.getInt("invernaderoID");
				System.out.println("PlantaID: " + plantaID + "\nInvernaderoID: " + invernaderoID + "\nCantidad: "
						+ cantidad + "\nFecha de plantacion: " + fechaPlantado);
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
				int invernaderoID = resultado.getInt("invernaderoID");
				System.out.println("Invernadero ID: " + invernaderoID + "\nPropietarioID: " + propietarioID
						+ "\nNombre:" + nombre);
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
				int invernaderoID = resultado.getInt("invernaderoID");
				System.out.println("Invernadero ID: " + invernaderoID + "\nPropietarioID: " + propietarioID
						+ "\nPlantaID: " + plantaID);
				System.out.println("----------------------");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void setPlanta(Planta p) {
		query = "insert into planta (PlantaID,nombre) values ('" + p.getId() + "' ,'" + p.getNombre() + "')";
		try {
			st.executeUpdate(query);
			System.out.println("Planta agregado");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void setCondicion(Condiciones c, Planta p) {
		query = "insert into condiciones (CondicionID,descripcion,temporada,humedadHambienteIdeal,litrosMediaIdeal,temperaturaIdeal,nivelLuzIdeal,plantaID) values ('"
				+ c.getCondicionID() + "' ,'" + c.getDescripcion() + "','" + c.getTemporada() + "','"
				+ c.getHumedadIdeal() + "','" + c.getLitrosMediaIdeal() + "','" + c.getTemperaturaIdeal() + "','"
				+ c.getNivelLuzIdeal() + "','" + p.getId() + "')";
		try {
			st.executeUpdate(query);
			System.out.println("Condicion agregado");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void setTiene(Tiene t) {
		query = "insert into tiene (plantaID,condicionID) values ('" + t.getPlantaID() + "' ,'" + t.getCondicionID() + "')";
		try {
			st.executeUpdate(query);
			System.out.println("Tiene agregado");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void setHaber(Haber h) {
		query = "insert into haber (cantidad,fechaPlantado,plantaID,invernaderoID) values ('" + h.getCantidad() + "' ,'"
				+ h.getFechaPlantado() + "','" + h.getPlantaID() + "','" + h.getInvernaderoID() + "')";
		try {
			st.executeUpdate(query);
			System.out.println("Haber agregado");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void setEspecie(Especie e, Planta p) {
		query = "insert into especie (especieID,nombreEspecie,plantaID) values ('" + e.especieID + "','" + e.getNombreEspecie()
				+ "' ,'" + p.getId() + "')";
		try {
			st.executeUpdate(query);
			System.out.println("Especie agregado");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void setInvernadero(Invernadero i) {
		query = "insert into invernadero (invernaderoID,descripcion,areaCultivo) values ('" + i.getInvernaderoID() + "' ,'"
				+ i.getDescripcion() + "','" + i.getAreaCultivo() + "')";

		try {
			st.executeUpdate(query);
			System.out.println("Invernadero agregado");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void setPropietario(Propietario p, Invernadero i) {
		query = "insert into propietario (propietarioID,nombre,invernaderoID) values ('" + p.getPropietarioID() + "' ,'"
				+ p.getNombre() + "','" + p.getInventarioID() + "')";
		try {
			st.executeUpdate(query);
			System.out.println("Propietario agregado");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void setCuidar(Propietario p, Planta p1, Invernadero i) {
		query = "insert into cuidar (propietarioID,plantaID,invernaderoID) values ('" + p.getPropietarioID() + "' ,'"
				+ p1.getId() + "','" + i.getInvernaderoID() + "')";
		try {
			st.executeUpdate(query);
			System.out.println("Cuidar agregado");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void setCuidar(Cuidar c) {
		query = "insert into cuidar (propietarioID,plantaID,invernaderoID) values ('" + c.getPropietarioID() + "' ,'"
				+ c.getPlantaID() + "','" + c.getInvernaderoID() + "')";
		try {
			st.executeUpdate(query);
			System.out.println("Cuidar agregado");
		} catch (SQLException ex) {
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

    public void eliminarPlanta(String plantaID) {
		query = "delete from planta where plantaID = '" + plantaID + "'";
		try {
			st.executeUpdate(query);
			System.out.println("Planta eliminado");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
		
}
