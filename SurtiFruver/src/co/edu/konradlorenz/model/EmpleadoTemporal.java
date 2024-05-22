package co.edu.konradlorenz.model;

public class EmpleadoTemporal extends Empleado {
	private short HorasTrabajadas;

	public EmpleadoTemporal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpleadoTemporal(String nombre, String cargo, long salario) {
		super(nombre, cargo, salario);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoTemporal(String cargo,String nombre,  long salario, short horasTrabajadas) {
		super(nombre, cargo, salario);
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
