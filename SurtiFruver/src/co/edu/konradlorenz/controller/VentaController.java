package co.edu.konradlorenz.controller;
import java.util.ArrayList;
import java.util.List;

import co.edu.konradlorenz.model.DetalleVenta;
import co.edu.konradlorenz.model.Producto;
import co.edu.konradlorenz.model.Venta;

public class VentaController {
    private Venta ventaActual;
    private List<Venta> ventasRealizadas;
    
    public VentaController() {
        this.ventaActual = new Venta();
        this.ventasRealizadas = new ArrayList<>();
    }

    public void abrirCaja (short op) {//arrancar
    	
    	switch (op) {
    	case 1: //registrar nueva venta
    		do {
    		VentaActual();
    		}while(op!=8);
    	break;
    	
    	case 2: //mostrar todas las ventas 
    		obtenerVentasRealizadas(); 
    	break;
    	}
    }
    public String registrarVenta(String fecha, String nombre) {
        ventaActual.setFecha(fecha);
        ventaActual.setNombre(nombre);
        double total = ventaActual.ventaTotal();
        return "Venta registrada: " + ventaActual+ "Total de la venta: " + total;
        
    }

    public Venta getVentaActual() {
        return ventaActual;
    }


    public double calcularIngresosVenta() {
    	double total=0;
    	for (Venta venta : ventasRealizadas) {
    		total=total+venta.ventaTotal();	
		}
		return total;
    } 
    

    public List<Venta> obtenerVentasRealizadas() {
        return ventasRealizadas;
    }
}