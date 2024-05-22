package co.edu.konradlorenz.model;

import java.util.ArrayList;

public class Proveedor {
	private String nombre;
    private String direccion;
    private String numeroTelefonico;
    private ArrayList<Producto> productosSuministrados;

    public Proveedor() {
	
	}
	public Proveedor(String nombre, String direccion, String numeroTelefonico,
			ArrayList<Producto> productosSuministrados) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroTelefonico = numeroTelefonico;
		this.productosSuministrados = productosSuministrados;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}
	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
	public ArrayList<Producto> getProductosSuministrados() {
		return productosSuministrados;
	}
	public void setProductosSuministrados(ArrayList<Producto> productosSuministrados) {
		this.productosSuministrados = productosSuministrados;
	}
	

	public void agregarProducto(Producto producto) {
		productosSuministrados.add(producto);
	}
	public void eliminarProducto(Producto producto) {
		productosSuministrados.remove(producto);
	}
    
}
