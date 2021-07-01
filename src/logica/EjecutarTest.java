package logica;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class EjecutarTest {
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
	public void calcularGruposTest() {
		GrupoDePersonas personas=GrupoDePersonas.leerJSON("personas.JSON");

		assertEquals(grupo1, Ejecutar.calcularGrupos(personas).get(0));
		assertEquals(grupo2, Ejecutar.calcularGrupos(personas).get(1));
	}
}
