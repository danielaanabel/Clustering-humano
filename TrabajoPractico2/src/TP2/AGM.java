package TP2;

import java.util.ArrayList;

public class AGM {

	public static GrafoConPesos algoritmoPrim(GrafoConPesos g) {
		
		verificarGrafoNoVacio(g);
		GrafoConPesos agm=new GrafoConPesos(g.tamano());

		ArrayList<Integer> marcados=new ArrayList<Integer>();
		marcados.add(0);//agrego el vertice inicial arbitrario

		boolean[] verticesG=new boolean[g.tamano()];//vertices aun no marcados
		verticesG[0]=true;

		int [] arista=new int[2];

		int i=0;
		while(i<g.tamano()-1){
			int minimo=0xff;
			for(int v=0;v<marcados.size();v++){
				for(int n=0;n<verticesG.length;n++) if(verticesG[n]==false){
					if(g.obtenerPesoArista(marcados.get(v), n) < minimo){
						minimo=g.obtenerPesoArista(marcados.get(v),n);
						arista[0]=marcados.get(v);
						arista[1]=n;
					}
				}	
			}
			marcados.add(arista[1]);
			verticesG[arista[1]]=true; 
			minimo=g.obtenerPesoArista(arista[0],arista[1]);
			agm.agregarAristaConPeso(arista[0], arista[1], minimo);
			i++;
		}
		return agm;
	}

	private static void verificarGrafoNoVacio(GrafoConPesos g) {
		if(g.tamano()==0)
			throw new RuntimeException("No se puede generar un AGM de un grafo vacio");
		
	}


}
