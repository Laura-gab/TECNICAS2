package co.edu.konradlorenz.model;

public class DetalleVenta {

	Producto producto = new Producto();
	private int cantidad;
	private double valor;
	public DetalleVenta() {
		// TODO Auto-generated constructor stub
	}

	public DetalleVenta(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.valor = (cantidad*producto.precioVenta());
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
    
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "DetalleVenta [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	 
	
	
}
