package co.edu.konradlorenz.model;

public abstract class Empleado {
    private String nombre;
    private String cargo;
    private long salario;
    

	public Empleado(String nombre, String cargo, long salario) {
		super();
		this.nombre = nombre;
		this.cargo = cargo;
		this.salario = salario;
	}


	public Empleado() {
	}


	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", cargo=" + cargo + ", salario=" + salario + "]";
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public long getSalario() {
		return salario;
	}


	public long setSalario(long salario) {
		return this.salario = salario;
	}
	
	
    public abstract long calcularSalario();
 

    

    
    
}
