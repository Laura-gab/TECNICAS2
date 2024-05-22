package co.edu.konradlorenz.model;

class EmpleadoFijo extends Empleado {
	private short DiasTrabajados;

	public EmpleadoFijo(String nombre, String cargo, short diasTrabajados) {
		super(nombre, cargo);
		DiasTrabajados = diasTrabajados;
	}
	
	public EmpleadoFijo() {}


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
