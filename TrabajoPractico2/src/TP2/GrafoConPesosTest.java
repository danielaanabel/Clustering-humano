package TP2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
  
public class GrafoConPesosTest {
	GrupoDePersonas listaPersonas;

	@Before
	public void inicializar() {
		Persona pepe=new Persona("Pepe", 1, 2, 3, 4);
		Persona jose=new Persona("Jose", 2, 1, 1, 4);
		Persona daniel=new Persona("Daniel", 2, 5, 1, 4);
		Persona juan=new Persona("juan", 3, 3,3, 3);
		Persona lara=new Persona("Lara", 2, 2, 2, 2);
		listaPersonas=new GrupoDePersonas();
		listaPersonas.agregarPersona(pepe);
		listaPersonas.agregarPersona(jose);
		listaPersonas.agregarPersona(daniel);
		listaPersonas.agregarPersona(juan);
		listaPersonas.agregarPersona(lara);
	}

	@Test 
	public void similaridadTest() {
		GrafoConPesos grafo=new GrafoConPesos(3);
		int p1=grafo.similaridad(listaPersonas.getListaDePersonas().get(0),listaPersonas.getListaDePersonas().get(1));
		int p2=grafo.similaridad(listaPersonas.getListaDePersonas().get(1),listaPersonas.getListaDePersonas().get(2));
		int p3=grafo.similaridad(listaPersonas.getListaDePersonas().get(0),listaPersonas.getListaDePersonas().get(2));
		
		grafo.agregarAristaConPeso(0, 1, p1);
		grafo.agregarAristaConPeso(1, 2, p2);
		grafo.agregarAristaConPeso(0, 2, p3);
		
		assertEquals(grafo.obtenerPesoArista(0, 1), 4);
		assertEquals(grafo.obtenerPesoArista(1, 2), 4);
		assertEquals(grafo.obtenerPesoArista(0, 2), 6);	
	}

}
