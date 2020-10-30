package TP2;

import java.util.ArrayList;
// otra implementacion de prim es tener todos los vertices por visitar en un array
// y cada vez que visito un vertice lo quito y lo agrego a los ya marcados



public class AGM {

	public static GrafoConPesos generarArbolMinimo(GrafoConPesos g) 
	{	
		GrafoConPesos agm=new GrafoConPesos(g.tamano());
		
		ArrayList<Integer> marcados=new ArrayList<Integer>();
		marcados.add(0);//agrego el vertice inicial
		
		ArrayList<Integer> verticesG=new ArrayList<Integer>();//vertices aun no visitados
		for(Integer j=0;j<g.tamano();j++)
		{
			verticesG.add(j);
		}
		verticesG.remove(0);

		int [][] aristas=new int[1][3]; 	

		int i=0;
		while(i<g.tamano()-1){
			int minimo=0xfff;
			for(int v=0;v<marcados.size();v++){
				for(int n=0;n<verticesG.size();n++){
					if(g.obtenerPesoArista(marcados.get(v), verticesG.get(n))<minimo) {
						minimo=g.obtenerPesoArista(marcados.get(v), verticesG.get(n));
						aristas[0][0]=marcados.get(v);
						aristas[0][1]=verticesG.get(n);
						aristas[0][2]=minimo;
					}
				}		
			}
			Integer a=aristas[0][1];
			marcados.add(a);
			verticesG.remove(a);
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
