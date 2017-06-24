package ar.edu.unlam.pb2.clubNoHomeros.bar;

import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.pb2.clubNoHomeros.bar.Bar;
import ar.edu.unlam.pb2.clubNoHomeros.bar.BarCerradoException;
import ar.edu.unlam.pb2.clubNoHomeros.cliente.Cliente;


public class BarTest {

	@Test
	public void admitirClientes() throws BarCerradoException {
		Bar bar = new Bar();
		bar.abrir();

		bar.ingresoCliente(new Cliente("Ariel", 26));
		bar.ingresoCliente(new Cliente("Manolo", 28));
		bar.ingresoCliente(new Cliente("Daniela", 21));
		bar.ingresoCliente(new Cliente("Carla", 35));
		
		int clientesEsperados = 4;

		Assert.assertEquals(clientesEsperados, bar.getClientes().size());
	}

	@Test
	public void noAdmitirClientesConMismoNombre() throws BarCerradoException {
		Bar bar = new Bar();
		bar.abrir();

		bar.ingresoCliente(new Cliente("Ariel", 26));
		bar.ingresoCliente(new Cliente("Ariel", 21));
		bar.ingresoCliente(new Cliente("Manolo", 28));
		bar.ingresoCliente(new Cliente("Manolo", 24));
		
		int clientesEsperados = 2;

		Assert.assertEquals(clientesEsperados, bar.getClientes().size());
	}
	
	@Test
	public void ordenarClientesPorNombre() throws BarCerradoException {
		Bar bar = new Bar();
		bar.abrir();

		bar.ingresoCliente(new Cliente("Ariel", 26));
		bar.ingresoCliente(new Cliente("Manolo", 28));
		bar.ingresoCliente(new Cliente("Daniela", 21));
		bar.ingresoCliente(new Cliente("Carla", 35));
		
		TreeSet<Cliente> listaEsperada = new TreeSet<>();
		listaEsperada.add(new Cliente("Ariel", 26));
		listaEsperada.add(new Cliente("Carla", 35));
		listaEsperada.add(new Cliente("Daniela", 21));
		listaEsperada.add(new Cliente("Manolo", 28));

		Assert.assertEquals(listaEsperada, bar.getClientes());
		
		Assert.assertTrue(bar.getClientes().first().equals(new Cliente("Ariel", 26)));
		Assert.assertTrue(bar.getClientes().last().equals(new Cliente("Manolo", 28)));
	}
	
	@Test
	public void ordenarClientesPorEdad() throws BarCerradoException {
		Bar bar = new Bar();
		bar.abrir();

		bar.ingresoCliente(new Cliente("Ariel", 26));
		bar.ingresoCliente(new Cliente("Manolo", 28));
		bar.ingresoCliente(new Cliente("Daniela", 21));
		bar.ingresoCliente(new Cliente("Carla", 35));
		
		ArrayList<Cliente> listaEsperada = new ArrayList<>();
		listaEsperada.add(new Cliente("Daniela", 21));
		listaEsperada.add(new Cliente("Ariel", 26));
		listaEsperada.add(new Cliente("Manolo", 28));
		listaEsperada.add(new Cliente("Carla", 35));
		
		ArrayList<Cliente> resultado = bar.getClientesOrdenadosPorEdad();

		Assert.assertEquals(listaEsperada, resultado);
		
		Assert.assertTrue(resultado.get(0).equals(new Cliente("Daniela", 21)));
		Assert.assertTrue(resultado.get(resultado.size() - 1).equals(new Cliente("Carla", 35)));
	}
	
	@Test(expected = BarCerradoException.class)
	public void lanzarExceptionSiElBarEstaCerrado() throws BarCerradoException {
		Bar bar = new Bar();
		bar.cerrar();

		bar.ingresoCliente(new Cliente("Manolo", 28));
		bar.ingresoCliente(new Cliente("Daniela", 21));
		bar.ingresoCliente(new Cliente("Carla", 35));

		Assert.assertFalse(bar.barAbierto());
	}
	
}
