package test;

import org.junit.Before;
import org.junit.Test;

import logica.AGM;
import logica.GrafoConPesos;

public class AGMTest {
	GrafoConPesos grafo;
	
	@Before
	public void inicializar() {
		grafo=new GrafoConPesos(5);
		grafo.agregarAristaConPeso(0, 1, 9);
		grafo.agregarAristaConPeso(0, 2, 9);
		grafo.agregarAristaConPeso(0, 3, 9);
		grafo.agregarAristaConPeso(0, 4, 5);
		grafo.agregarAristaConPeso(1, 2, 0);
		grafo.agregarAristaConPeso(1, 3, 6);
		grafo.agregarAristaConPeso(1, 4, 8);
		grafo.agregarAristaConPeso(2, 3, 6);
		grafo.agregarAristaConPeso(2, 4, 8);
		grafo.agregarAristaConPeso(3, 4, 4);
	}
	
	@Test
	public void arbolGeneradoMinimoTest() {
		GrafoConPesos esperado=new GrafoConPesos(5);
		esperado.agregarAristaConPeso(0, 4, 5);
		esperado.agregarAristaConPeso(1, 2, 0);
		esperado.agregarAristaConPeso(1, 3, 6);
		esperado.agregarAristaConPeso(3, 4, 4);
		
		Assert.grafoIgual(AGM.algoritmoPrim(grafo), esperado);	
	}
	
	@Test (expected = RuntimeException.class)
	public void agmVacioTest() {
		GrafoConPesos obtenido=new GrafoConPesos(0);
		GrafoConPesos esperado=new GrafoConPesos(0);
	
		Assert.grafoIgual(AGM.algoritmoPrim(obtenido), esperado);	
	}
}
