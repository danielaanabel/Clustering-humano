package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GrafoConPesos {

	// Representamos el grafo por su matriz de adyacencia
	private Integer[][] A;

	// La cantidad de vertices esta predeterminada desde el constructor
	public GrafoConPesos(int vertices)
	{
		A = new Integer[vertices][vertices];
	}

	public void agregarAristaConPeso(int i, int j,int peso) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		if( peso < 0 )
			throw new IllegalArgumentException("El peso no puede ser negativo: " + peso);
		A[i][j] = peso;
		A[j][i] = peso; 
	}

	public int obtenerPesoArista(int i, int j) {

		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		if(A[i][j]!=null) {
			return A[i][j];
		}
		return 0xff;
	}

	public void eliminarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		
		A[i][j] = null;
		A[j][i] = null;
	}

	public boolean existeArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		return A[i][j]!=null;
	}

	public int tamano() {
		return A.length;
	}

	// Vecinos de un vertice
	public Set<Integer> vecinos(int i) {
		verificarVertice(i);

		Set<Integer> ret = new HashSet<Integer>();
		for(int j = 0; j < this.tamano(); ++j) if( i != j ) {
			if( this.existeArista(i,j) )
				ret.add(j);
		}

		return ret;		
	}

	public void eliminarAristaMayorPeso() {
		int maximo=-1;
		int coordenadaX = 0;
		int coordenadaY = 0;
		for(int f=0;f<A.length;f++){
			for (int c = 0; c <A[0].length; c++){
				if(A[f][c]!=null && A[f][c] > maximo){
					maximo=A[f][c];
					coordenadaX=f;
					coordenadaY=c;
				}
			}
		}
		if(coordenadaX!=coordenadaY)
			eliminarArista(coordenadaX, coordenadaY);
	}
	
	public static GrafoConPesos construirGrafoCompleto(ArrayList<Persona> listaDePersonas) {
		GrafoConPesos grafo=new GrafoConPesos(listaDePersonas.size());

		for(int i=0;i<grafo.tamano();i++) {
			for(int j=0;j<grafo.tamano();j++) if(i!=j) {
					int peso=Persona.similaridad(listaDePersonas.get(i), listaDePersonas.get(j));
					grafo.agregarAristaConPeso(i, j, peso);
				}
		}
		return grafo;
	}
	
	// Verifica que sea un vertice valido
	private void verificarVertice(int i) {
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);

		if( i >= A.length )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	// Verifica que i y j sean distintos
	private void verificarDistintos(int i, int j) {
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}
}


