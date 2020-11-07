package TP2;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class GrupoDePersonasTest {
	HashSet<String> grupo1;
	HashSet<String> grupo2;
	
	@Before
	public void inicializar() {
		grupo1=new HashSet<String>();
		grupo2=new HashSet<String>();

		grupo1.add("Lucia");
		grupo1.add("Daniel");
		grupo1.add("Fabian");
		grupo1.add("Adrian");
		grupo1.add("Valentina");
		grupo1.add("Alicia");
		grupo1.add("Matheo");

		grupo2.add("Federico");
		grupo2.add("Johana");
		grupo2.add("Sabrina");	
	}

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
		personas.agregarPersona("Federico", 2,1,3,4);

		assertEquals(personas.obtenerPersona(3), "Adrian");
	}

	@Test 
	public void calcularGruposTest() {
		GrupoDePersonas personas=new GrupoDePersonas();
		personas.agregarPersona("Lucia", 2,5,2,3);
		personas.agregarPersona("Daniel", 1,5,3,3);
		personas.agregarPersona("Fabian", 2,5,2,5);
		personas.agregarPersona("Adrian", 1,5,3,4);
		personas.agregarPersona("Valentina", 3,3,2,3);
		personas.agregarPersona("Federico", 2,1,3,4);
		personas.agregarPersona("Alicia", 2,5,1,2);
		personas.agregarPersona("Johana", 4,1,5,2);
		personas.agregarPersona("Sabrina", 3,1,4,5);
		personas.agregarPersona("Matheo", 1,5,1,5);

		assertEquals(grupo1, GrupoDePersonas.calcularGrupos(personas).get(0));;
		assertEquals(grupo2, GrupoDePersonas.calcularGrupos(personas).get(1));
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
