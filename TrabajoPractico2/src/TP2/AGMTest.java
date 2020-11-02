package TP2;


import org.junit.Test;

public class AGMTest {

	@Test
	public void arbolGeneradoMinimoTest() {
		GrafoConPesos grafo=new GrafoConPesos(5);
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
		grafo.imprimiGrafo();
		
		GrafoConPesos esperado=new GrafoConPesos(5);
		esperado.agregarAristaConPeso(0, 4, 5);
		esperado.agregarAristaConPeso(1, 2, 0);
		esperado.agregarAristaConPeso(1, 3, 6);
		esperado.agregarAristaConPeso(3, 4, 4);
		esperado.imprimiGrafo();
		
		Assert.grafoIgual(AGM.generarArbolMinimo(grafo), esperado);	
	}

}
