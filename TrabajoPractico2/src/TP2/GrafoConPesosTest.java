package TP2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

  
public class GrafoConPesosTest {
	
	@Test
	public void eliminarAristaMayorTest() {
		
		GrafoConPesos grafo=new GrafoConPesos(5);
		grafo.agregarAristaConPeso(0, 1, 0);
		grafo.agregarAristaConPeso(2, 3, 8);
		grafo.agregarAristaConPeso(3, 4, 5);
		grafo.agregarAristaConPeso(1, 2, 9);
		
		assertTrue(grafo.existeArista(1, 2));
		grafo.eliminarAristaMayorPeso();	
		assertFalse(grafo.existeArista(1, 2));
	}
	
	@Test
	public void grafoCompletoTest() {
		ArrayList<Persona> listaPersonas=new ArrayList<Persona>();
		Persona pepe=new Persona("Pepe", 1, 2, 3, 4);
		Persona jose=new Persona("Jose", 2, 1, 1, 4);
		Persona daniel=new Persona("Daniel", 2, 5, 1, 4);
		Persona juan=new Persona("juan", 2, 5, 1, 4);
		Persona lara=new Persona("Lara", 2, 2, 2, 2);
		listaPersonas=new ArrayList<Persona>(); 
		listaPersonas.add(pepe);
		listaPersonas.add(jose);
		listaPersonas.add(daniel);
		listaPersonas.add(juan);
		listaPersonas.add(lara);
		GrafoConPesos grafo=GrafoConPesos.construirGrafoCompleto(listaPersonas);
		
		Assert.GrafoCompleto(grafo);		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void verticeNegativoTest() {
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.vecinos(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verticeExcedidoTest() {
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.vecinos(5);
	}

	@Test
	public void todosAisladosTest() {
		GrafoConPesos grafo = new GrafoConPesos(5);
		assertEquals(0, grafo.vecinos(2).size());
	}
	
	@Test
	public void verticeUniversalTest() {
		GrafoConPesos grafo = new GrafoConPesos(4);
		grafo.agregarAristaConPeso(1, 0, 5);
		grafo.agregarAristaConPeso(1, 2, 5);
		grafo.agregarAristaConPeso(1, 3, 5);
		
		int[] esperado = {0, 2, 3};
		Assert.iguales(esperado, grafo.vecinos(1));
	}
	
	@Test
	public void verticeNormalTest() {
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.agregarAristaConPeso(1, 3, 7);
		grafo.agregarAristaConPeso(2, 3, 8);
		grafo.agregarAristaConPeso(2, 4, 6);
		
		int[] esperados = {1, 2};
		Assert.iguales(esperados, grafo.vecinos(3));
	}

}
