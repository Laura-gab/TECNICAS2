package co.edu.konradlorenz.view;

import java.util.Scanner;

public class VistaVenta {
    private Scanner scanner;

    public int mostrarMenuVentas() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Registrar venta");
        System.out.println("2. Mostrar todas las ventas");
        System.out.println("3. Calcular ingresos por ventas");
        System.out.println("4. Cerrar caja");
        return scanner.nextInt();
    }
    public VistaVenta() {
        this.scanner = new Scanner(System.in);
    }

    public short obtenerClave() {
        System.out.print("Ingrese la clave del producto: ");
        return scanner.nextShort();
    }

    public int obtenerCantidad() {
        System.out.print("Ingrese la cantidad: ");
        return scanner.nextInt();
    }

    public String obtenerFecha() {
        System.out.print("Ingrese la fecha (dd/mm/yyyy): ");
        return scanner.next();
    }

    public boolean continuarRegistrando() {
        System.out.print("¿Desea registrar otro producto en la venta? (s/n): ");
        String respuesta = scanner.next();
        return respuesta.equalsIgnoreCase("s");
    }
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarResultado(Object resultado) {
        System.out.println("Resultado: " + resultado);
    }
}
