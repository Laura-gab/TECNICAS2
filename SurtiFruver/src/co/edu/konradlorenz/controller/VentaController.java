package co.edu.konradlorenz.controller;
import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.view.VistaVenta;

import java.util.ArrayList;
import java.util.List;

public class VentaController {
    private final Almacenamiento almacenamiento;
    private final VistaVenta ventaVista;
    private Venta ventaActual;
    private ArrayList<Venta> ventasRealizadas;

    public VentaController(Almacenamiento almacenamiento, VistaVenta vistaVenta) {
        this.ventaActual = new Venta();
        this.ventasRealizadas = new ArrayList<>();
        this.almacenamiento = almacenamiento;
        this.ventaVista = vistaVenta;
    }
    public VentaController(Almacenamiento almacenamiento) {
        this.ventaActual = new Venta();
        this.ventasRealizadas = new ArrayList<>();
        this.almacenamiento = almacenamiento;
    }

    // Maneja el menú de ventas
    public void abrirCaja() {
        int opcion;
        do {
            opcion = ventaVista.mostrarMenuVentas();
            switch (opcion) {
                case 1:
                    registrarVenta();
                    break;
                case 2:
                    mostrarVentas();
                    break;
                case 3:
                    calcularIngresosVentas();
                    break;
                case 4:
                    ventaVista.mostrarMensaje("Cerrando caja...");
                    break;
                default:
                    ventaVista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 4);
    }

    // Registra una nueva venta
    private void registrarVenta() {
        ventaActual.setFecha(ventaVista.obtenerFecha());
        boolean continuar = true;
        while (continuar) {
            short clave = ventaVista.obtenerClave();
            int cantidad = ventaVista.obtenerCantidad();
            ventaActual.agregarProducto(clave, cantidad, almacenamiento);
            continuar = ventaVista.continuarRegistrando();
        }
        ventasRealizadas.add(ventaActual);
        ventaVista.mostrarMensaje("Venta registrada: " + ventaActual);
        ventaActual = new Venta(); // Crear una nueva venta para la próxima vez
    }

    // Muestra todas las ventas realizadas
    private void mostrarVentas() {
        List<Venta> ventas = obtenerVentasRealizadas();
        for (Venta venta : ventas) {
            ventaVista.mostrarResultado(venta);
        }
    }

    // Calcula los ingresos totales por ventas
    private void calcularIngresosVentas() {
        double ingresos = calcularIngresosVenta();
        ventaVista.mostrarResultado("Ingresos por ventas totales: " + ingresos);
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
}