package co.edu.konradlorenz.view;

import java.util.Scanner;

public class AdminVista {
    private Scanner scanner;

    public AdminVista() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar elemento");
        System.out.println("2. Modificar elemento");
        System.out.println("3. Eliminar elemento");
        System.out.println("4. Obtener elemento");
        System.out.println("5. Salir");
        return scanner.nextInt();
    }

    public short obtenerClave() {
        System.out.print("Ingrese la clave del elemento: ");
        return scanner.nextShort();
    }

    public Object obtenerValor() {
        System.out.print("Ingrese el valor del elemento: ");
        return scanner.nextShort();
    }

    public void mostrarResultado(Object resultado) {
        System.out.println("Resultado: " + resultado);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
