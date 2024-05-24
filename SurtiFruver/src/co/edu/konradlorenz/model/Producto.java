package co.edu.konradlorenz.model;

public class Producto implements PrecioProducto {

    private String nombre;
    private short codigo;
    private double precioCompra;
    private short cantidadCompra;
    
    

	public Producto(short codigo, String nombre, double precioCompra, short cantidadCompra) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.precioCompra = precioCompra;
		this.cantidadCompra=cantidadCompra;
	}


	public Producto() {
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public short getCodigo() {
		return codigo;
	}


	public void setCodigo(short codigo) {
		this.codigo = codigo;
	}


	


	public short getCantidadCompra() {
		return cantidadCompra;
	}


	public void setCantidadCompra(short cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}


	public double getPrecioCompra() {
		return precioCompra;
	}


	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}


	

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", precioCompra=" + precioCompra
				+ ", cantidadCompra=" + cantidadCompra + "]";
	}


	@Override
	public double precioVenta() {
		
		double precioFinal = ( precioCompra*GANANCIA)+precioCompra;
		 return precioFinal/cantidadCompra;
	}
	
	
}
