package TP2;

public class Main {
	
	public static void main(String[] args) {

		
		GrupoDePersonas personas=new GrupoDePersonas();
		personas.agregarPersona("pepe", 1,5,3,4);
		personas.agregarPersona("jose", 2,1,3,4);
		personas.agregarPersona("daniel", 2,5,1,4);
		personas.agregarPersona("juan", 2,5,1,4);
		personas.agregarPersona("lara", 2,1,5,4);
		
		String json=personas.generarJSONPretty();
		
		personas.guardarJSON(json, "personas.JSON");
	}

}
