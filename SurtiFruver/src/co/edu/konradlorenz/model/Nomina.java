package co.edu.konradlorenz.model;
import java.util.List;
import java.io.*;
import java.util.ArrayList;

public class Nomina {
	private List<Empleado> empleados;

	public Nomina() {
        empleados = new ArrayList<>();
        cargarEmpleados();
	    }    

	public void agregarEmpleado(Empleado empleado) {
	    empleados.add(empleado);
	    }    

	public List<Empleado> obtenerEmpleados() {
	    return empleados;
	    }

	public double calcularTotalSalarios() {
	    double total = 0;
	    for (Empleado empleado : empleados) {
	       total += empleado.calcularSalario();
	    }
	    return total;
	}
	
	public void cargarEmpleados() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USUARIO\\IdeaProjects\\TECNICAS2\\SurtiFruver\\src\\co\\edu\\konradlorenz\\model\\Empleados"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String cargo = datos[0];
                String nombre = datos[1];
                short trabajo = Short.valueOf(datos[2]);
                
                if (cargo.equalsIgnoreCase("Fijo")) {
                    EmpleadoFijo empleado = new EmpleadoFijo(nombre,cargo, trabajo);
                    agregarEmpleado(empleado);
                } else if (cargo.equalsIgnoreCase("Temporal")) {
                    EmpleadoTemporal empleado = new EmpleadoTemporal(nombre, cargo, trabajo);
                    agregarEmpleado(empleado);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejar la excepción adecuadamente en la vista
        }
}
}