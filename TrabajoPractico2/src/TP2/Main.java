package TP2;

public class Main {
	
	public static void main(String[] args) {

		
		GrupoDePersonas personas=new GrupoDePersonas();
		personas.agregarPersona("Lucia", 2,5,2,3);
		personas.agregarPersona("Valentina", 5,3,2,3);
		personas.agregarPersona("Daniel", 1,5,3,3);
		personas.agregarPersona("Fabian", 2,5,2,5);
		personas.agregarPersona("Adrian", 1,5,3,4);
		personas.agregarPersona("Federico", 2,1,3,4);
		personas.agregarPersona("Alicia", 2,5,1,2);
		personas.agregarPersona("Johana", 4,1,5,2);
		personas.agregarPersona("Sabrina", 3,1,4,5);
		personas.agregarPersona("Matheo", 1,5,1,5);
		
		String json=personas.generarJSONPretty();
		
		personas.guardarJSON(json, "personas.JSON");
		
//		GrafoConPesos.construirGrafoCompleto(personas.getPersonas()).imprimiGrafo();
//		System.out.println();
//		AGM.algoritmoPrim(GrafoConPesos.construirGrafoCompleto(personas.getPersonas())).imprimiGrafo();
	}

}
