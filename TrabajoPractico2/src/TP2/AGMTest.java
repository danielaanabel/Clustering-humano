package TP2;


import org.junit.Before;
import org.junit.Test;

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
		
		Assert.grafoIgual(AGM.generarArbolMinimo(grafo), esperado);	
	}
	
	

}
