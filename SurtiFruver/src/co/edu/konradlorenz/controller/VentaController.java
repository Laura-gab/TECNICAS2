package co.edu.konradlorenz.controller;
import co.edu.konradlorenz.model.Venta;

import java.util.ArrayList;
import java.util.List;

public class VentaController {
    private Venta ventaActual;
    private ArrayList<Venta> ventasRealizadas;
    
    public VentaController() {
        this.ventaActual = new Venta();
        this.ventasRealizadas = new ArrayList<Venta>();
    }

    public void abrirCaja (short op) {//arrancar
    	
    	switch (op) {
    	case 1: //registrar nueva venta
    		do {
    		VentaActul();
    		}while(op!=8);
        case 2: //eliminar venta

        case 3: //añadir Fecha
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