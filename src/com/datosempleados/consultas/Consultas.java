package com.datosempleados.consultas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.datosempleados.conexion.Conexion;
import com.datosempleados.empleado.Empleado;

/**
 * En esta clase tenemos los métodos en los que usamos sentencia preparadas para interactuar con los datos de nuestra BD
 * @author Raquel
 *
 */
public class Consultas {

	/**
	 * Método al que le pasamos una instancia de Empleado por parámetro y lo inserta
	 * en nuestra base de datos
	 * 
	 * @param empleado
	 */
	public static void insertarEmpleado(Empleado empleado) {
		try (Connection conexion = Conexion.getConnection();
				PreparedStatement pstm = conexion.prepareStatement(
						"INSERT into empleados (nombre, apellido, fecha_nacimiento, salario) values (?,?,?,?)")) {
			pstm.setString(1, empleado.getNombre());
			pstm.setString(2, empleado.getApellido());
			pstm.setDate(3, Date.valueOf(empleado.getFechaNacimiento()));
			pstm.setDouble(4, empleado.getSalario());

			pstm.executeUpdate();
			pstm.close();
			System.out.println(empleado.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método al que le pasamos un id deEmpleado y una instancia de Empleado para
	 * actualizar los datos de ese empleado identificandolo por el id
	 * 
	 * @param empleado
	 */
	public static void modificarEmpleado(int idEmpleado, Empleado empleado) {
		try (Connection conexion = Conexion.getConnection();
				PreparedStatement pstm = conexion.prepareStatement(
						"UPDATE empleados SET nombre=?, apellido=?, fecha_nacimiento=?, salario=? where id = ?")) {

			pstm.setString(1, empleado.getNombre());
			pstm.setString(2, empleado.getApellido());
			pstm.setDate(3, Date.valueOf(empleado.getFechaNacimiento()));
			pstm.setDouble(4, empleado.getSalario());
			pstm.setInt(5, idEmpleado);

			pstm.executeUpdate();

			empleado.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método que nos devolverá una lista de empleados tras recorrer las filas y
	 * almacenar todos los empleados en la misma
	 * 
	 * @return lista de empleados
	 */
	public static List<Empleado> mostrarEmpleados() {
		List<Empleado> empleadosList = new ArrayList<Empleado>();
		try (Connection conexion = Conexion.getConnection();
				PreparedStatement pstm = conexion.prepareStatement("SELECT * FROM empleados")) {
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				LocalDate fecha_nacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
				double salario = rs.getDouble("salario");

				Empleado empleado = new Empleado(id, nombre, apellido, fecha_nacimiento, salario);
				empleadosList.add(empleado);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empleadosList;
	}

	/**
	 * Método que devuelve una lista de empleado que contendrá los empleados que
	 * tengan coincidiencia con el apellido pasado por parámetro
	 * 
	 * @param apellido
	 * @return lista de empleados
	 */
	public static List<Empleado> mostrarEmpleadosPorApellido(String apellido) {
		List<Empleado> empleadosList = new ArrayList<Empleado>();
		try (Connection conexion = Conexion.getConnection();
				PreparedStatement pstm = conexion.prepareStatement("SELECT * FROM empleados where apellido = ?")) {
			pstm.setString(1, apellido);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido2 = rs.getString("apellido");
				LocalDate fecha_nacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
				double salario = rs.getDouble("salario");

				Empleado empleado = new Empleado(id, nombre, apellido2, fecha_nacimiento, salario);
				empleadosList.add(empleado);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empleadosList;
	}
}
