package co.edu.konradlorenz.controller;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;

	import co.edu.konradlorenz.model.*;
	import co.edu.konradlorenz.view.AdminVista;

public class Admin {
		
		private Venta ventasRealizadas;
		private double gastosTotales; 
		private double balance;
		private Nomina nomina;
		private Almacenamiento almacenamiento;
		private AdminVista adminVista;
		private ArrayList<Venta> almacenamientoVenta = new ArrayList<>();

		public void arrancar(){
			gestionarAlmacenamiento();
		}
		public Admin() {
			this.nomina= new Nomina();
			this.almacenamiento = new Almacenamiento();
			this.adminVista= new AdminVista();
		}

		public String realizarNomina() {
			if (nomina != null) {

				// Obtener la lista de empleados
				List<Empleado> empleados = nomina.obtenerEmpleados();
				if (empleados != null) {
					String reportesNomina = "";
					for (Empleado empleado : nomina.obtenerEmpleados()) {
						double salario = empleado.calcularSalario();
						reportesNomina += "Empleado: " + empleado.getNombre() + ", Salario: " + salario + "\n";
					}
					return reportesNomina;
				} else {
					return "Error: La lista de empleados está vacía o no se pudo cargar.";
				}
			} else {
				return "Error: La nomina no está inicializada.";
			}
		}

		public void gestionarAlmacenamiento() {
			boolean salir = false;
			while (!salir) {
				int opcion = adminVista.mostrarMenu();
				short clave;
				Object valor;

				switch (opcion) {
					case 1:
						// Agregar elemento
						clave = adminVista.obtenerClave();
						valor = adminVista.obtenerValor();
						almacenamiento.agregarProducto(clave, new Almacenamiento(new Producto(), (short) valor, 0));
						adminVista.mostrarMensaje("Elemento agregado.");
						break;

					case 2:
						// Modificar elemento
						clave = adminVista.obtenerClave();
						valor = adminVista.obtenerValor();
						almacenamiento.agregarProducto(clave, new Almacenamiento(new Producto(), (short) valor, 0));
						adminVista.mostrarMensaje("Elemento modificado.");
						break;

					case 3:
						// Eliminar elemento
						clave = adminVista.obtenerClave();
						almacenamiento.eliminarProducto(clave);
						adminVista.mostrarMensaje("Elemento eliminado.");
						break;

					case 4:
						// Obtener elemento
						clave = adminVista.obtenerClave();
						Object resultado = almacenamiento.obtenerElemento(clave);
						adminVista.mostrarResultado(resultado);
						break;

					case 5:
						// Salir
						salir = true;
						adminVista.mostrarMensaje("Saliendo...");
						break;

					default:
						adminVista.mostrarMensaje("Opción no válida.");
						break;
				}
			}
		}

		public void calcularGastosIngresos() {}
		

		
		
		
		
	}

