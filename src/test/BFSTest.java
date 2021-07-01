package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import logica.BFS;
import logica.GrafoConPesos;

public class BFSTest {
 
	@Test
	public void alcanzablesDosComponentesTest() {
		GrafoConPesos grafo=new GrafoConPesos(5);

		grafo.agregarAristaConPeso(0, 1, 4);
		grafo.agregarAristaConPeso(1, 2, 4);
		grafo.agregarAristaConPeso(0, 2, 4);
		grafo.agregarAristaConPeso(3, 4, 4);

		int[] esperado= {0,1,2};
		Assert.iguales(esperado,BFS.alcanzables(grafo, 1));
	}

	@Test
	public void alcanzablesUnaAristaTest() {
		GrafoConPesos grafo=new GrafoConPesos(5);
		grafo.agregarAristaConPeso(3, 4, 5);

		int[] esperado= {3,4};
		Assert.iguales(esperado,BFS.alcanzables(grafo, 3));
	}

	@Test
	public void alcanzablesAisladoTest() {
		GrafoConPesos grafo=new GrafoConPesos(5);

		int[] esperado= {1};
		Assert.iguales(esperado,BFS.alcanzables(grafo, 1));
	}

	@Test
	public void alcanzablesConexoTest() {
		GrafoConPesos grafo=new GrafoConPesos(4);
		grafo.agregarAristaConPeso(0, 2, 1);
		grafo.agregarAristaConPeso(1, 2, 1);
		grafo.agregarAristaConPeso(1, 3, 1);

		int[] esperado= {0,1,2,3};
		Assert.iguales(esperado,BFS.alcanzables(grafo, 3));
	}
	
	@Test 
	public void esConexoTest() {
		GrafoConPesos grafo=new GrafoConPesos(4);
		grafo.agregarAristaConPeso(0, 2, 1);
		grafo.agregarAristaConPeso(1, 2, 1);
		grafo.agregarAristaConPeso(1, 3, 1);
		
		assertTrue(BFS.esConexo(grafo));
	}
	
	@Test 
	public void grafoVacioTest() {
		GrafoConPesos grafo=new GrafoConPesos(0);
		
		assertFalse(BFS.esConexo(grafo));
	}
}
