package TP2;

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

	public void agregarAristaConPeso(int i, int j,int peso)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		if( peso < 0 )
			throw new IllegalArgumentException("El peso no puede ser negativo: " + peso);
		//int peso=similaridad(personas.get(i),personas.get(j)); 
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

	public void eliminarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		
		A[i][j] = null;
		A[j][i] = null;
	}

	public boolean existeArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		return A[i][j]!=null;
	}

	public int tamano()
	{
		return A.length;
	}

	// Vecinos de un vertice
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i);

		Set<Integer> ret = new HashSet<Integer>();
		for(int j = 0; j < this.tamano(); ++j) if( i != j )
		{
			if( this.existeArista(i,j) )
				ret.add(j);
		}

		return ret;		
	}

	public int similaridad(Persona i, Persona j) 
	{
		int iSimilaridad=Math.abs(i.getiDeportes()-j.getiDeportes())
				+Math.abs(i.getiMusica()-j.getiMusica())
				+Math.abs(i.getiEspectaculos()-j.getiEspectaculos())
				+Math.abs(i.getiCiencia()-j.getiCiencia());
		return iSimilaridad;
	}

	public void eliminarAristaMayorPeso() 
	{
		int maximo=0;
		int coordenadaX = 0;
		int coordenadaY = 0;

		for(int f=0;f<A.length;++f){
			for (int c = 0; c <A[0].length; c++){
				if(A[f][c]!=null && A[f][c]>maximo){
					maximo=A[f][c];
					coordenadaX=f;
					coordenadaY=c;
				}
			}
		}
		eliminarArista(coordenadaX, coordenadaY);
	}

	// Verifica que sea un vertice valido
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);

		if( i >= A.length )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	// Verifica que i y j sean distintos
	private void verificarDistintos(int i, int j)
	{
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}

	public void imprimiGrafo() {
		for(int f=0;f<A.length;++f){
			for (int c = 0; c <A[0].length; c++){
				if(A[f][c]==null)
					System.out.print("-");
				else 
					System.out.print(A[f][c]);
				System.out.print("|");
			}
			System.out.println();
		}
	}


}


