package TP2;

import java.util.ArrayList;




public class AGM {


	public static GrafoConPesos generarArbolMinimo(GrafoConPesos g) 
	{	
		GrafoConPesos agm=new GrafoConPesos(g.tamano());
		ArrayList<Integer> visitados=new ArrayList<Integer>();
		int [][] aristas=new int[1][3]; 
		visitados.add(0);

		int i=0;
		while(i<g.tamano()-1){
			int minimo=0xfff;
			for(int v=0;v<visitados.size();v++){
				for(int n=0;n<g.tamano();n++){
					if(!visitados.contains(n)){//ver si se puede quitar esto
						if(g.obtenerPesoArista(visitados.get(v), n)<minimo) {
							minimo=g.obtenerPesoArista(visitados.get(v), n);
							aristas[0][0]=visitados.get(v);
							aristas[0][1]=n;
							aristas[0][2]=minimo;
						}
					}
				}		
			}
			visitados.add(aristas[0][1]);
			agm.agregarAristaConPeso(aristas[0][0], aristas[0][1], aristas[0][2]);
			i++;
		}

		return agm;
	}
	
	
	
	public static void main(String[] args) {
	GrafoConPesos grafo=new GrafoConPesos(5);
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

	grafo.imprimiGrafo();
	System.out.println();
	AGM.generarArbolMinimo(grafo).imprimiGrafo();

}




}
