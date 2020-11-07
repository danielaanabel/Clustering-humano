package TP2;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

public class Assert
{
	// Verifica que sean iguales como conjuntos
	public static void iguales(int[] esperado, Set<Integer> obtenido) {
		
		assertEquals(esperado.length, obtenido.size());

		for(int i=0; i<esperado.length; ++i)
			assertTrue( obtenido.contains(esperado[i]));
	}
	
	public static void grafoIgual(GrafoConPesos g1,GrafoConPesos g2) {
		
		assertEquals(g1.tamano(), g2.tamano());

		for(int f=0;f<g1.tamano();f++) {
			for(int c=0;c<g1.tamano();c++) if(f!=c){
				assertTrue(g1.obtenerPesoArista(f, c)==g2.obtenerPesoArista(f, c));
			}
		}		
	}
	
	public static void GrafoCompleto(GrafoConPesos g) {
		for(int i=0;i<g.tamano();i++) {
			for(int j=0;j<g.tamano();j++) if(i!=j) {
				assertTrue(g.existeArista(i, j));
			}
		}		
	}
	
	
	
	
	
	
}
