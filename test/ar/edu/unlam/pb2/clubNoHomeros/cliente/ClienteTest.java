package ar.edu.unlam.pb2.clubNoHomeros.cliente;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

	@Test
	public void compararNombre() {
		Cliente cliente1 = new Cliente("Tomás", 25);
		Cliente cliente2 = new Cliente("Tomás", 28);
		
		int resultado = cliente1.compareTo(cliente2);
		
		//Tienen el mismo nombre
		Assert.assertEquals(0, resultado);
		
		//Tienen distinto nombre
		Cliente cliente3 = new Cliente("Pepe", 28);
		resultado = cliente1.compareTo(cliente3);
		Assert.assertNotEquals(0, resultado);
	}

}
