package com.datosempleado.main;

import java.time.LocalDate;

import com.datosempleados.consultas.Consultas;
import com.datosempleados.empleado.Empleado;

/**
 * Clase Main donde tendremos nuestro método main
 * 
 * @author Raquel
 *
 */
public class Main {

	public static void main(String[] args) {

		// Recorremos la lista de empleados y los mostramos por consola
		System.out.println(" EMPLEADOS -------------");
		for (Empleado e : Consultas.mostrarEmpleados()) {
			System.out.println(e.toString());
		}
		System.out.println(" FIN EMPLEADOS -------------");

		// Recorremos la lista de apellidos coincidentes con el indicado y los mostramos
		// por consola
		System.out.println(" APELLIDOS COINCIDENTES -------------");
		for (Empleado e : Consultas.mostrarEmpleadosPorApellido("Torres")) {
			System.out.println(e.toString());
		}
		System.out.println(" FIN APELLIDOS COINCIDENTES -------------");

		// Insertamos un nuevo empleado
		Consultas.insertarEmpleado(new Empleado("Raquel", "Cernadas", LocalDate.now(), 200.5));

		// Modificamos un empleado existente
		Consultas.modificarEmpleado(1, new Empleado("Rosario", "Melaso", LocalDate.now(), 200.5));

	}

}
