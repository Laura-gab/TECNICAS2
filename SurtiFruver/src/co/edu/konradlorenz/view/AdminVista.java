package co.edu.konradlorenz.view;

import java.util.Scanner;

public class AdminVista {
    private Scanner scanner;

    public AdminVista() {
        this.scanner = new Scanner(System.in);
    }

    public short valorShort(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextShort();
    }

    public String string(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }

    public int valorInt(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public double valorDouble(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    public void mostrarResultado(Object resultado) {
        System.out.println("Resultado: " + resultado);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int mostrarMenu(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextInt();
    }
}

