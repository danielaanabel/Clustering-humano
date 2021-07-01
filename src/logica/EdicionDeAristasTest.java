package logica;


import static org.junit.Assert.*;

import org.junit.Test;

public class EdicionDeAristasTest { 
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativoTest()
	{
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.agregarAristaConPeso(-1, 3, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest()
	{
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.agregarAristaConPeso(5, 2, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest()
	{
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.agregarAristaConPeso(2, -1, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest()
	{
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.agregarAristaConPeso(2, 5, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregarLoopTest()
	{
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.agregarAristaConPeso(2, 2, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregarPesoNegativoTest()
	{
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.agregarAristaConPeso(2, 4, -1);
	}

	@Test
	public void aristaExistenteTest() {
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.agregarAristaConPeso(2, 3, 5);
		assertTrue( grafo.existeArista(2, 3) );
	}

	@Test
	public void aristaOpuestaTest()
	{
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.agregarAristaConPeso(2, 3, 5);
		assertTrue( grafo.existeArista(3, 2) );
	}

	@Test
	public void aristaInexistenteTest()
	{
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.agregarAristaConPeso(2, 3, 5);
		assertFalse( grafo.existeArista(1, 4) );
	}

	@Test
	public void agregarAristaDosVecesTest()
	{
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.agregarAristaConPeso(2, 3, 5);
		grafo.agregarAristaConPeso(2, 3, 5);

		assertTrue( grafo.existeArista(2, 3) );
	}
	
	@Test
	public void eliminarAristaExistenteTest()
	{
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.agregarAristaConPeso(2, 4, 5);
		
		grafo.eliminarArista(2, 4);
		assertFalse( grafo.existeArista(2, 4) );
	}

	@Test
	public void eliminarAristaInexistenteTest()
	{
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.eliminarArista(2, 4);
		assertFalse( grafo.existeArista(2, 4) );
	}
	
	@Test
	public void eliminarAristaDosVecesTest()
	{
		GrafoConPesos grafo = new GrafoConPesos(5);
		grafo.agregarAristaConPeso(2, 4, 5);
		
		grafo.eliminarArista(2, 4);
		grafo.eliminarArista(2, 4);
		assertFalse( grafo.existeArista(2, 4) );
	}
	
}

