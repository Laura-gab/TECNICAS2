package co.edu.konradlorenz.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Almacenamiento {
	 Producto producto = new Producto();
	 short cantidad;
	 private int DiasAlmacenado;
	 private static HashMap<Short, Almacenamiento> almacenamiento= new HashMap<>();
		

		public Almacenamiento(Producto producto, short cantidad, int diasAlmacenado) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		DiasAlmacenado = diasAlmacenado;

	}

	public Almacenamiento() {
		llenarAlmacenamiento();
	}
		
		public void llenarAlmacenamiento() {
			File fichero = new File("C:\\Users\\USUARIO\\IdeaProjects\\TECNICAS2\\SurtiFruver\\src\\co\\edu\\konradlorenz\\model\\Productos2");

	        try ( BufferedReader reader = new BufferedReader(new FileReader(fichero));){

	            String linea;
	                while ((linea = reader.readLine()) != null) {
	                String array[] = linea.split(";");
	                Producto producto1= new Producto (Short.valueOf(array[0]), array[1],Integer.parseInt(array[2]),Double.parseDouble(array[3]),Short.valueOf(array[4]));
					this.cantidad = Short.valueOf(array[4]);
					Almacenamiento almace1 = new Almacenamiento( producto1,Short.valueOf(array[4]),Integer.parseInt(array[2]));
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
			return DiasAlmacenado;
		}

		public void setDiasAlmacenado(int diasAlmacenado) {
			DiasAlmacenado = diasAlmacenado;
		}

		@Override
		public String toString() {
			return "Almacenamiento [producto=" + producto + ", cantidad=" + cantidad + "]";
		}


		public String alertaProductoAgotandose() {
			if(cantidad<10)
				return"Poco producto";
			else
				return " "; 
		}

	    public String alertaMaximoDiasAlmacenado() {
			if(DiasAlmacenado<5)
				return"Producto a punto de expirar";
			else
				return " "; 
	    }
	    public int actualizarCantidadProductoVenta (short cantidadV) throws CantidadNegativaException {

	    	 	if(cantidad<=0 || cantidad<cantidadV)
					throw new CantidadNegativaException() ;
				else
					cantidad= (short) (cantidad- cantidadV);
	    	return cantidad;
	    }

		public int actualizarCantidadProductoAñadir (short cantidadA) {
			cantidad= (short) (cantidad+ cantidadA);
		return cantidad;
	}
	    public void agregarProducto(short codigo,Almacenamiento almace) {

			almacenamiento.put(codigo,almace);
		}

		public void eliminarProducto(short codigo) {
			almacenamiento.remove( codigo);
		 }
			
		public Producto obtenerElemento(short clave) {
		    Almacenamiento producto= almacenamiento.get(clave);     
			return producto.getProducto();
		    }
}
