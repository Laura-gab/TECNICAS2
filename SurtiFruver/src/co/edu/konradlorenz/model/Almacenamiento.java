package co.edu.konradlorenz.model;

import co.edu.konradlorenz.controller.VentaController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Almacenamiento {
	private Producto producto;
	private short cantidad;
	private int diasAlmacenado;
	private HashMap<Short, Almacenamiento> almacenamiento = new HashMap<>();

	public Almacenamiento(Producto producto, short cantidad, int diasAlmacenado) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.diasAlmacenado = diasAlmacenado;
	}

	public Almacenamiento() {
	}

	public void llenarAlmacenamiento() {
		File fichero = new File("SurtiFruver/src/co/edu/konradlorenz/model/Productos2");

		try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] array = linea.split(";");
				Producto producto1 = new Producto(Short.valueOf(array[0]), array[1],Double.parseDouble(array[3]), Short.valueOf(array[4]));
				Almacenamiento almace1 = new Almacenamiento(producto1, Short.valueOf(array[4]), Integer.parseInt(array[2]));
				almacenamiento.put(Short.valueOf(array[0]), almace1);
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public short getCantidad() {
		return cantidad;
	}

	public void setCantidad(short cantidad) {
		this.cantidad = cantidad;
	}

	public int getDiasAlmacenado() {
		return diasAlmacenado;
	}

	public void setDiasAlmacenado(int diasAlmacenado) {
		this.diasAlmacenado = diasAlmacenado;
	}

	public Producto obtenerElemento(short clave) {
		Almacenamiento producto= almacenamiento.get(clave);
		return producto.getProducto();
	}

	public void agregarProducto(short clave, Almacenamiento alm) {
		almacenamiento.put(clave, alm);
	}

	public  HashMap<Short, Almacenamiento> getAlmacenamientos() {
		return almacenamiento;
	}

	public boolean eliminarProducto(short clave) {

		return false;
	}
	public int actualizarCantidadProductoVenta (short clave,int cantidadV) throws CantidadNegativaException {

		Almacenamiento almacen = almacenamiento.get(clave);
		if (almacen != null && almacen.getCantidad() >= cantidad) {
			almacen.setCantidad((short) (almacen.getCantidad() - cantidad));
		} else {
			throw new CantidadNegativaException() ;}

		return cantidad;
	}

	public int actualizarCantidadProductoAñadir (short cantidadA) {
		cantidad= (short) (cantidad+ cantidadA);
		return cantidad;
	}
	public String alertaMaximoDiasAlmacenado(Almacenamiento producto) {
		if(producto.diasAlmacenado<5)
			return"Producto a punto de expirar";
		else
			return " ";
	}

}


