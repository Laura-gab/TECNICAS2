package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Venta {

	private ArrayList<DetalleVenta> productosVendidos;
	private String fecha;

	public Venta() {
		this.productosVendidos = new ArrayList<>();
	}

	public ArrayList<DetalleVenta> getProductosVendidos() {
		return productosVendidos;
	}

	public void setProductosVendidos(ArrayList<DetalleVenta> productosVendidos) {
		this.productosVendidos = productosVendidos;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double ventaTotal() {
		double total = 0;
		for (DetalleVenta detalleVenta : productosVendidos) {
			total += detalleVenta.getValor();
		}
		return total;
	}

	public String agregarProducto(short clave, int cantidad,Almacenamiento almacenamiento) throws CantidadNegativaException {
		Producto producto = almacenamiento.obtenerElemento(clave);
		if( producto!=null){
			DetalleVenta detalleVenta = new DetalleVenta(producto, cantidad);
			productosVendidos.add(detalleVenta);
			almacenamiento.actualizarCantidadProductoVenta(clave, cantidad);
			return "Producto creada con exito";
		} else{
			return "El producto no existe";
		}
	}

	@Override
	public String toString() {
		return "Venta [productosVendidos=" + productosVendidos + ", fecha=" + fecha + "]";
	}
}
