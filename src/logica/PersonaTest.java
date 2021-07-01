package logica;


import org.junit.Before;
import org.junit.Test;

public class PersonaTest {
	GrupoDePersonas personas;
	
	@Before
	public void inicializar() {
		personas=new GrupoDePersonas();
	}
	
	@Test (expected = RuntimeException.class)
	public void agregarNombreInvalidoTest() {
		personas.agregarPersona("Da", 1, 2, 3, 3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void interesDeportesFueraDeRangoTest() {
		personas.agregarPersona("Daniel", 6, 2, 3, 3);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void interesMusicaFueraDeRangoTest() {
		personas.agregarPersona("Daniel", 1, -1, 3, 3);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void interesEspectaculoFueraDeRangoTest() {
		personas.agregarPersona("Daniel", 1, 2, 6, 3);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void interesCienciaFueraDeRangoTest() {
		personas.agregarPersona("Daniel", 1, 2, 3, 0);
	}

}
