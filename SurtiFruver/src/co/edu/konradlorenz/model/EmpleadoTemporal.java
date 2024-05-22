package co.edu.konradlorenz.model;

public class EmpleadoTemporal extends Empleado {
	private short HorasTrabajadas;

	public EmpleadoTemporal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpleadoTemporal(String nombre, String cargo) {
		super(nombre, cargo);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoTemporal(String nombre,String cargo, short horasTrabajadas) {
		super(nombre, cargo);
		HorasTrabajadas = horasTrabajadas;
	}

	@Override
	public String toString() {
		return "EmpleadoTemporal [HorasTrabajadas=" + HorasTrabajadas + "]";
	}

    public short getHorasTrabajadas() {
		return HorasTrabajadas;
	}

	public void setHorasTrabajadas(short horasTrabajadas) {
		HorasTrabajadas = horasTrabajadas;
	}

	@Override
	public long calcularSalario() {
       long salario = 7000*HorasTrabajadas;
        return setSalario(salario); 
    }
	
}
