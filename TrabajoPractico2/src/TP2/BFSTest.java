package TP2;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class BFSTest {
	GrupoDePersonas listaPersonas;
	//modificar completo
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
	public void seProduceCicloTest() {
		GrafoConPesos grafo=new GrafoConPesos(5);
		int p1=grafo.similaridad(listaPersonas.getListaDePersonas().get(0),listaPersonas.getListaDePersonas().get(1));
		int p2=grafo.similaridad(listaPersonas.getListaDePersonas().get(1),listaPersonas.getListaDePersonas().get(2));
		
		grafo.agregarAristaConPeso(0, 1,p1);
		grafo.agregarAristaConPeso(1, 2,p2);
		
		assertTrue(BFS.hayCiclo(grafo, 0, 2));
	}
	  
	@Test 
	public void noSeProduceCicloTest() {
		GrafoConPesos grafo=new GrafoConPesos(5);
		int p1=grafo.similaridad(listaPersonas.getListaDePersonas().get(0),listaPersonas.getListaDePersonas().get(1));
		int p2=grafo.similaridad(listaPersonas.getListaDePersonas().get(1),listaPersonas.getListaDePersonas().get(2));
		
		grafo.agregarAristaConPeso(0, 1,p1);
		grafo.agregarAristaConPeso(1, 2,p2);
		
		assertFalse(BFS.hayCiclo(grafo, 2, 3));
	} 
	

//	@Test
//	public void alcanzablesDosComponentesTest() {
//		GrafoConPesos grafo=new GrafoConPesos(5);
//
//		grafo.agregarAristaConPeso(0, 1,listaPersonas.getListaDePersonas());
//		grafo.agregarAristaConPeso(1, 2,listaPersonas.getListaDePersonas());
//		grafo.agregarAristaConPeso(0, 2,listaPersonas.getListaDePersonas());
//		grafo.agregarAristaConPeso(3, 4,listaPersonas.getListaDePersonas());
//
//		int[] esperado= {0,1,2};
//		Assert.iguales(esperado,BFS.alcanzables(grafo, 1));
//	}
//
//	@Test
//	public void alcanzablesUnaAristaTest() {
//		GrafoConPesos grafo=new GrafoConPesos(5);
//		grafo.agregarAristaConPeso(3, 4,listaPersonas.getListaDePersonas());
//
//		int[] esperado= {3,4};
//		Assert.iguales(esperado,BFS.alcanzables(grafo, 3));
//	}

	@Test
	public void alcanzablesAisladoTest() {
		GrafoConPesos grafo=new GrafoConPesos(5);

		int[] esperado= {1};
		Assert.iguales(esperado,BFS.alcanzables(grafo, 1));
	}

//	@Test
//	public void alcanzablesConexoTest() {
//		GrafoConPesos grafo=new GrafoConPesos(4);
//		grafo.agregarAristaConPeso(0, 2,listaPersonas.getListaDePersonas());
//		grafo.agregarAristaConPeso(1, 2,listaPersonas.getListaDePersonas());
//		grafo.agregarAristaConPeso(1, 3,listaPersonas.getListaDePersonas());
//
//		int[] esperado= {0,1,2,3};
//		Assert.iguales(esperado,BFS.alcanzables(grafo, 3));
//	}


}
