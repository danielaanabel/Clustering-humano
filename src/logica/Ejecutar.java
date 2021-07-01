package logica;
import java.util.ArrayList;
import java.util.HashSet;

public class Ejecutar {
	
	public static ArrayList<HashSet<String>> calcularGrupos(GrupoDePersonas listaDePersonas) {
		GrafoConPesos grafo=GrafoConPesos.construirGrafoCompleto(listaDePersonas.getPersonas());
		grafo=AGM.algoritmoPrim(grafo);
		grafo.eliminarAristaMayorPeso();
		return obtenerGrupos(grafo,listaDePersonas.getPersonas());
	}

	public static ArrayList<HashSet<String>> obtenerGrupos(GrafoConPesos g,ArrayList<Persona> l) {
		ArrayList<HashSet<String>> grupos=new ArrayList<HashSet<String>>();
		HashSet<String> grupo1= new HashSet<String>();
		HashSet<String> grupo2= new HashSet<String>();

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
	

}
