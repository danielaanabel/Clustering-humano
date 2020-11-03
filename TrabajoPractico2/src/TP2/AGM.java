package TP2;

import java.util.ArrayList;

public class AGM {
 
	public static GrafoConPesos generarArbolMinimo(GrafoConPesos g)
	{	
		GrafoConPesos agm=new GrafoConPesos(g.tamano());

		ArrayList<Integer> marcados=new ArrayList<Integer>();
		marcados.add(0);//agrego el vertice inicial arbitrario

		boolean[] verticesG=new boolean[g.tamano()];//vertices aun no marcados
		verticesG[0]=true;

		Arista arista=new Arista();//aca voy guardando la arista minima encontrada

		int i=0;
		while(i<g.tamano()-1){
			int minimo=0xff;
			for(int v=0;v<marcados.size();v++){
				for(int n=0;n<verticesG.length;n++) if(verticesG[n]==false){
					if(g.obtenerPesoArista(marcados.get(v), n)<minimo){
						minimo=g.obtenerPesoArista(marcados.get(v),n);
						arista.setVerticeA(marcados.get(v));
						arista.setVerticeB(n);
						arista.setPeso(minimo);
					}
				}	
			}
			marcados.add(arista.getVerticeB());
			verticesG[arista.getVerticeB()]=true;
			agm.agregarAristaConPeso(arista.getVerticeA(), arista.getVerticeB(), arista.getPeso());
			i++;
		}
		return agm;
	}
	
	

}
