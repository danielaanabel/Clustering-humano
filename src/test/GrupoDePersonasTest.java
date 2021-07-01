package test;

import static org.junit.Assert.*;


import org.junit.Test;

import logica.GrupoDePersonas;

public class GrupoDePersonasTest {

	@Test 
	public void existePersonaTest() {
		GrupoDePersonas listaPersonas =new GrupoDePersonas();
		listaPersonas.agregarPersona("Leonardo", 4, 1, 3, 5);

		assertTrue(listaPersonas.existePersona("Leonardo"));
	}

	@Test 
	public void noExistePersonaTest() {
		GrupoDePersonas listaPersonas =new GrupoDePersonas();
		
		assertFalse(listaPersonas.existePersona("Rodrigo"));
	}

	@Test 
	public void cantidadDePersonasTest() {
		GrupoDePersonas personas =new GrupoDePersonas();
		personas.agregarPersona("Lucia", 2,5,2,3);
		personas.agregarPersona("Daniel", 1,5,3,3);
		personas.agregarPersona("Fabian", 2,5,2,5);
		personas.agregarPersona("Adrian", 1,5,3,4);
		personas.agregarPersona("Valentina", 3,3,2,3);
		personas.agregarPersona("Federico", 2,1,3,4);

		assertEquals(personas.cantPersonas(), 6);
	}

	@Test
	public void obtenerPersonasTest() {
		GrupoDePersonas personas =new GrupoDePersonas();
		personas.agregarPersona("Lucia", 2,5,2,3);
		personas.agregarPersona("Daniel", 1,5,3,3);
		personas.agregarPersona("Fabian", 2,5,2,5);
		personas.agregarPersona("Adrian", 1,5,3,4);
		personas.agregarPersona("Valentina", 3,3,2,3);

		assertEquals(personas.obtenerPersona(3), "Adrian");
	}
	
	@Test 
	public void anexarListaDePersonasTest() {
		GrupoDePersonas listaPersonas =new GrupoDePersonas();
		listaPersonas.agregarPersona("Lucia", 2,5,2,3);
		listaPersonas.agregarPersona("Daniel", 1,5,3,3);
		GrupoDePersonas otraLista =new GrupoDePersonas();
		otraLista.agregarPersona("Sabrina", 3,1,4,5);
		otraLista.agregarPersona("Matheo", 1,5,1,5);
		otraLista.agregarPersona("Alicia", 2,5,1,2);
		
		listaPersonas.anexarListaPersonas(otraLista);
		
		assertEquals(5,listaPersonas.cantPersonas());			
	}
}
