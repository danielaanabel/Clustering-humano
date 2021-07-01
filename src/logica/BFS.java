package logica; 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;




public class BFS {   

	public static Set<Integer> alcanzables(GrafoConPesos grafo,int origen) {	
		Set<Integer> marcados= new HashSet<Integer>();
		ArrayList<Integer> pendientes= new ArrayList<Integer>();
		pendientes.add(origen);

		while(pendientes.size()!=0)
		{
			int actual=pendientes.get(0);
			marcados.add(actual);
			pendientes.remove(0);

			for(Integer v:grafo.vecinos(actual))
			{
				if(!marcados.contains(v))
					pendientes.add(v);
			} 
		}
		return marcados;
	}

	public static boolean esConexo(GrafoConPesos grafo) {
		if(grafo.tamano()==0) 
			return false;
		
		return alcanzables(grafo, 0).size()==grafo.tamano();
	}

}
