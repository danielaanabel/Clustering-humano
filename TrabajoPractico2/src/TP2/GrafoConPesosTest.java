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
		grafo.agregarAristaConPeso(0, 1, listaPersonas.getListaDePersonas());
		grafo.agregarAristaConPeso(1, 2, listaPersonas.getListaDePersonas());
		grafo.agregarAristaConPeso(0, 2, listaPersonas.getListaDePersonas());
		
		assertEquals(grafo.obtenerPesoArista(0, 1), 4);
		assertEquals(grafo.obtenerPesoArista(1, 2), 4);
		assertEquals(grafo.obtenerPesoArista(0, 2), 6);	
	}

}
