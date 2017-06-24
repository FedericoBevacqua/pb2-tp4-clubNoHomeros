package ar.edu.unlam.pb2.clubNoHomeros.bar;

public class BarCerradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public BarCerradoException() {
        super("Error, el bar esta cerrado.");
    }
}
