package co.edu.konradlorenz.controller;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;

	import co.edu.konradlorenz.model.*;
	import co.edu.konradlorenz.view.AdminVista;
	import co.edu.konradlorenz.view.NominaView;

public class Admin {

	private double gastosTotales;
	private double balance;
	private Nomina nomina;
	private Almacenamiento almacenamiento;
	private AdminVista adminVista;
	private VentaController ventaController;

	public Admin() {
		this.nomina = new Nomina();
		this.almacenamiento = new Almacenamiento();
		this.adminVista = new AdminVista();
		nomina = new Nomina();
		ventaController = new VentaController(almacenamiento);
	}
	public void arrancar() {
		int opcion;
	do {
		opcion = adminVista.mostrarMenu("Seleccione una opción:\n 1. Gestionar almacenamiento \n 2. Realizar nómina \n . Abrir caja \n";
		System.out.println("");
		System.out.println("3");
		System.out.println("4. Gestionar gastos e ingresos");
		System.out.println("5. Salir");

		switch (opcion) {
			case 1:
				gestionarAlmacenamiento();
				break;
			case 2:
				mostrarNomina();
				break;
			case 3:
				abrirCaja()
			DecrementarDiasAlmacenado();
				break;
			case 4:
				gestionarGastosEIngresos();
				break;
			case 5:
				adminVista.mostrarMensaje("Saliendo...");
				break;
			default:
				adminVista.mostrarMensaje("Opción no válida.");
		}
	} while (opcion != 5);
}

	public void realizarNomina() {
		NominaView nominaView = new NominaView(nomina);
		nominaView.setVisible(true);
	}
	public void gestionarAlmacenamiento() {
		boolean salir = false;
		while (!salir) {
			int opcion = adminVista.mostrarMenu("Seleccione una opción: \n 1. Agregar elemento \n 2. Modificar elemento\n 3. Eliminar elemento \n 4. Obtener elemento \n 5. Salir ");
			short clave;
			String nombre;
			int diasAlmacenado;
			double precioCompra;
			short cantidadCompra;

			switch (opcion) {
				case 1:
					// Agregar elemento
					clave = adminVista.valorShort("Ingrese la clave del elemento: ");
					nombre = adminVista.string("Ingrese el nombre del producto: ");
					diasAlmacenado = adminVista.valorInt("Ingrese los días almacenados del producto: ");
					precioCompra = adminVista.valorDouble("Ingrese el precio de compra del producto: ");
					cantidadCompra = adminVista.valorShort("Ingrese la cantidad de compra del producto: ");
					Producto nuevoProducto = new Producto(clave, nombre, precioCompra, cantidadCompra);
					almacenamiento.agregarProducto(clave, new Almacenamiento(nuevoProducto, cantidadCompra, diasAlmacenado));
					adminVista.mostrarMensaje("Elemento agregado.");
					break;

				case 2:
					// Modificar elemento
					clave = adminVista.valorShort("Ingrese la clave del elemento: ");

					// Obtener el producto actual antes de modificarlo
					Producto productoActual = almacenamiento.obtenerElemento(clave);
					if (productoActual != null) {
						adminVista.mostrarResultado("Producto actual: " + productoActual);
						modificarProducto(productoActual);
						adminVista.mostrarResultado("Elemento modificado" + productoActual);
					} else {
						adminVista.mostrarMensaje("Producto no encontrado.");
					}
					break;
				case 3:
					// Eliminar elemento
					clave = adminVista.valorShort("Ingrese la clave del elemento: ");
					if (almacenamiento.eliminarProducto(clave))
						adminVista.mostrarMensaje("Elemento eliminado.");
					else
						adminVista.mostrarMensaje("Elemento no eliminado.");
					break;
				case 4:
					// Obtener elemento
					clave = adminVista.valorShort("Ingrese la clave del elemento: ");
					Producto resultado = almacenamiento.obtenerElemento(clave);
					if (resultado != null) {
						adminVista.mostrarResultado(resultado);
					} else {
						adminVista.mostrarMensaje("Producto no encontrado.");
					}
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


	public void calcularGastosIngresos() {
	}

	public void modificarProducto(Producto producto) {
		boolean salir = false;
		while (!salir) {
			int opcionModificacion = adminVista.mostrarMenu("Seleccione el atributo a modificar: \n 1. Nombre\n 2. Días Almacenados \n 3. Precio de Compra \n 4. Cantidad de Compra \n 5. Salir");
			switch (opcionModificacion) {
				case 1:
					String nombre = adminVista.string("Ingrese el nombre del producto: ");
					producto.setNombre(nombre);
					break;
				case 2:
					short diasAlmacenado = adminVista.valorShort("Ingrese los dias de almacenado");
					almacenamiento.actualizarCantidadProductoAñadir(diasAlmacenado);
					break;
				case 3:
					double precioCompra = adminVista.valorDouble("Ingrese el precio de compra: ");
					producto.setPrecioCompra(precioCompra);
					break;
				case 4:
					short cantidadCompra = adminVista.valorShort("Ingrese la cantidad de compra del producto: ");
					producto.setCantidadCompra(cantidadCompra);
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

	private String decrementarDiasAlmacenado() {
		for (Almacenamiento almacen : almacenamiento.getAlmacenamientos().values()) {
			int diasAlmacenado = almacen.getDiasAlmacenado();
			if (diasAlmacenado > 0) {
				almacen.alertaMaximoDiasAlmacenado(almacen.setDiasAlmacenado(diasAlmacenado - 1));
				return " ";
			} else {
				Producto producto = almacen.getProducto();
				almacenamiento.eliminarProducto(almacen.getProducto().getCodigo());
				return "El producto " + producto.getNombre()+" con el codigo "+producto.getCodigo()+" se ha terminado";

			}
		}
        return "";
    }

}



