package TP2;

import java.util.ArrayList;




public class Ejecutar {
	
	public static ArrayList<ArrayList<String>> calcularGrupos(GrupoDePersonas listaDePersonas) {
		GrafoConPesos grafo=construirGrafoCompleto(listaDePersonas.getPersonas());
		grafo=AGM.algoritmoPrim(grafo);
		grafo.eliminarAristaMayorPeso();
		return obtenerGrupos(grafo,listaDePersonas.getPersonas());
	}
	
	public static GrafoConPesos construirGrafoCompleto(ArrayList<Persona> listaDePersonas) {
		GrafoConPesos grafo=new GrafoConPesos(listaDePersonas.size());

		//agrego aristas para formar grafo completo
		for(int i=0;i<grafo.tamano();i++) {
			for(int j=0;j<grafo.tamano();j++) {
				if(i!=j) {
					int peso=grafo.similaridad(listaDePersonas.get(i), listaDePersonas.get(j));
					grafo.agregarAristaConPeso(i, j, peso);
				}
			}
		}
		return grafo;
	}

	public static ArrayList<ArrayList<String>> obtenerGrupos(GrafoConPesos g,ArrayList<Persona> l) {
		ArrayList<ArrayList<String>> grupos=new ArrayList<ArrayList<String>>();
		ArrayList<String> grupo1= new ArrayList<String>();
		ArrayList<String> grupo2= new ArrayList<String>();

		for (int i = 0; i <l.size(); i++) {
			if(BFS.alcanzables(g, 0).contains(i)) 
				grupo1.add(l.get(i).getNombre());
			else 
				grupo2.add(l.get(i).getNombre());
		}
		grupos.add(grupo1);
		grupos.add(grupo2);

		return grupos;
	}
	

	

	public static void main(String[] args) {

		Persona pepe=new Persona("Pepe", 1, 5, 3, 4);
		Persona jose=new Persona("Jose", 2, 1, 3, 4);
		Persona daniel=new Persona("Daniel", 2, 5, 1, 4);
		Persona juan=new Persona("juan", 2, 5, 1, 4);
		Persona lara=new Persona("Lara", 2, 1, 5, 4);
		GrupoDePersonas listaPersonas=new GrupoDePersonas(); 
		listaPersonas.agregarPersona2(pepe);
		listaPersonas.agregarPersona2(jose);
		listaPersonas.agregarPersona2(daniel);
		listaPersonas.agregarPersona2(juan);
		listaPersonas.agregarPersona2(lara);

		ArrayList<ArrayList<String>> grupos=calcularGrupos(listaPersonas);

		for (String persona : grupos.get(0)) {
			System.out.println(persona);
		}
		System.out.println();
		
		for (String persona : grupos.get(1)) {
			System.out.println(persona);
		}

	}

}
