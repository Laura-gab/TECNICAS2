package co.edu.konradlorenz.controller;
import co.edu.konradlorenz.model.DetalleVenta;
import co.edu.konradlorenz.model.Venta;

import java.util.ArrayList;
import java.util.List;

public class VentaController {
    private Venta ventaActual;
    private ArrayList<Venta> ventasRealizadas;

    public VentaController() {
        this.ventaActual = new Venta();
        this.ventasRealizadas = new ArrayList<>();
    }

    public void abrirCaja (short op) {//arrancar

    	switch (op) {
    	case 1: //registrar venta
    		do {
    		//VentaActul();
    		}while(op!=8);
        case 2: //añadir Fecha
        break;
        case 3: //mostrar todas las ventas
             obtenerVentasRealizadas();
    	break;
    	
    	case 4: //salir

    	break;
    	}
    }
    public String registrarVenta() {
        ventasRealizadas.add(ventaActual);
        double total = ventaActual.ventaTotal();
        String resultado = "Venta registrada: " + ventaActual + " Total de la venta: " + total;
        ventaActual = new Venta(); // Crear una nueva venta actual para la próxima venta
        return resultado;
    }

    public Venta getVentaActual() {
        return ventaActual;
    }

    public double calcularIngresosVenta() {
        double total = 0;
        for (Venta venta : ventasRealizadas) {
            total += venta.ventaTotal();
        }
        return total;
    }

    public List<Venta> obtenerVentasRealizadas() {
        return ventasRealizadas;
    }

    public void agregarDetalleVenta(DetalleVenta detalleVenta) {
        this.ventaActual.add(detalleVenta);
    }
}