package ar.edu.unlam.pb2.clubNoHomeros.cliente;

import java.util.Comparator;

public class ComparadorClientePorEdad implements Comparator<Cliente> {

	@Override
	public int compare(Cliente cliente1, Cliente cliente2){
		return cliente1.getEdad() - cliente2.getEdad();
	}
	
}