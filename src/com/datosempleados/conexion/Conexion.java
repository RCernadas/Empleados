package com.datosempleados.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase Conexion en la que realizamos la conexión con nuestra base de datos MYSQL
 * @author Raquel
 *
 */
public class Conexion {
	private static final String URL = "jdbc:mysql://localhost:3306/bdempleados";
	private static final String USUARIO = "root";
	private static final String CONTRASENHA = "abc123.";

	public static Connection getConnection() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENHA);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
}
