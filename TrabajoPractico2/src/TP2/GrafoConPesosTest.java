package TP2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
  
public class GrafoConPesosTest {
	private ArrayList<Persona> listaPersonas;

	@Before
	public void inicializar() {
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
	}

	@Test 
	public void similaridadTest() {
		GrafoConPesos grafo=new GrafoConPesos(2);
		
		int p1=grafo.similaridad(listaPersonas.get(0),listaPersonas.get(1));
		grafo.agregarAristaConPeso(0, 1, p1);
		
		assertEquals(grafo.obtenerPesoArista(0, 1), 4);
	}
	
	@Test 
	public void similaridadIgualTest() {
		GrafoConPesos grafo=new GrafoConPesos(4);
		
		int p1=grafo.similaridad(listaPersonas.get(2),listaPersonas.get(3));
		grafo.agregarAristaConPeso(2, 3, p1);
		
		assertEquals(grafo.obtenerPesoArista(2, 3),0);	
	} 
	
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

}
