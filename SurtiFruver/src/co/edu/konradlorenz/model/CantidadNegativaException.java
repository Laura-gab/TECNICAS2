package co.edu.konradlorenz.model;

public class CantidadNegativaException extends Exception {
	public CantidadNegativaException () {
		super("No hay cantidad suficiente ");
	}

}
