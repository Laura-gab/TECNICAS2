package co.edu.konradlorenz.controller;

	import java.util.ArrayList;
	import java.util.HashMap;

	import co.edu.konradlorenz.model.*;

	public class Admin {
		
		private static HashMap<Short, Almacenamiento> almacenamiento= new HashMap<>();
		private Venta ventasRealizadas;
		private double gastosTotales; 
		private double balance;
		private ArrayList<Venta> almacenamientoVenta = new ArrayList<>();
		public void revisarVentas() {
			
		}
		
		public String realizarNomina(Nomina nomina) {
			 String reportesNomina = "";
			    for (Empleado empleado : nomina.obtenerEmpleados()) {
			        double salario = empleado.calcularSalario();
			        reportesNomina += "Empleado: " + empleado.getNombre() + ", Salario: " + salario + "\n";
			    }
			    return reportesNomina;
			}

		public void calcularGastosIngresos() {}
		
		public void gestionarAlmacenamiento() {
			switch () {
			
			case 1:
				almacenamiento.agregarProducto();
			}
		}
		
		
		
		
	}

