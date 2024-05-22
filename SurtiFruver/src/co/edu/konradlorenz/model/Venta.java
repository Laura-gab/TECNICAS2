package co.edu.konradlorenz.model;

import co.edu.konradlorenz.model.DetalleVenta;

import java.util.ArrayList;

public class Venta {
	
    private ArrayList<DetalleVenta> productosVendidos;
    private String fecha;
    private String nombre;
    	
    
    
	public Venta() {
		// TODO Auto-generated constructor stub
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



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	


	@Override
	public String toString() {
		return "Venta [productosVendidos=" + productosVendidos + ", fecha=" + fecha + ", nombre=" + nombre + "]";
	}


	public double ventaTotal() {
		double total=0;
		for (DetalleVenta detalleVenta : productosVendidos) {
			total=total+detalleVenta.getValor();
		}
		return total;
		
	}

	public String agregarProductoAVenta(DetalleVenta detalleVenta) {
        if (detalleVenta != null) {
            productosVendidos.add(detalleVenta);
            return "Producto agregado a la venta: " + detalleVenta;
        }
		else {
        return "Producto no agregado";
    }
	}
}