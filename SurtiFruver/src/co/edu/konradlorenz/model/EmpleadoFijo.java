package co.edu.konradlorenz.model;

class EmpleadoFijo extends Empleado {
	private short DiasTrabajados;

	public EmpleadoFijo(String nombre, String cargo, long salario, short diasTrabajados) {
		super(nombre, cargo, salario);
		DiasTrabajados = diasTrabajados;
	}
	
	public EmpleadoFijo() {}

	public EmpleadoFijo(String nombre, String cargo, long salario) {
		super(nombre, cargo, salario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmpleadoFijo [DiasTrabajados=" + DiasTrabajados + "]";
	}

	public short getDiasTrabajados() {
		return DiasTrabajados;
	}

	public void setDiasTrabajados(short diasTrabajados) {
		DiasTrabajados = diasTrabajados;
	}

	@Override
	public long calcularSalario() {
		long salario = DiasTrabajados*56000;
		return salario;
	}
	
	
}
