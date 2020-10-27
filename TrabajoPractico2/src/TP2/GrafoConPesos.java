package TP2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class GrafoConPesos {
	
//	public static void main(String[] args) {
//		Persona pepePersona=new Persona("pepe", 1, 2, 3, 4);
//		Persona danie=new Persona("Dany", 2, 1, 1, 4);
//		Persona daniel=new Persona("Daniel", 2, 5, 1, 4);
//		ArrayList<Persona> personas=new ArrayList<Persona>();
//		personas.add(pepePersona);
//		personas.add(danie);
//		personas.add(daniel);
//		GrafoConPesos grafo=new GrafoConPesos(personas.size());
//		grafo.agregarAristaConPeso(0, 1, personas);
//		grafo.agregarAristaConPeso(1, 2, personas);
//		grafo.agregarAristaConPeso(0, 2, personas);
//		
//		for(int f=0;f<grafo.A.length;++f){
//			for (int c = 0; c <grafo.A[0].length; c++){
//				System.out.print(grafo.A[f][c]);	
//			}
//			System.out.println();
//		}
//	}
	
	
	// Representamos el grafo por su matriz de adyacencia
	private Integer[][] A;

	// La cantidad de vertices esta predeterminada desde el constructor
	public GrafoConPesos(int vertices)
	{
		A = new Integer[vertices][vertices];
		
	}

	// Agregado de aristas
	public void agregarAristaConPeso(int i, int j,ArrayList<Persona> personas)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		
		int peso=similaridad(personas.get(i),personas.get(j));
		A[i][j] = peso;
		A[j][i] = peso;
	}
	
	public int obtenerPesoArista(int i, int j) {
		
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		int ret=A[i][j];
		
		return ret;
	}
	
	public int similaridad(Persona i, Persona j) 
	{
		int iSimilaridad=Math.abs(i.getiDeportes()-j.getiDeportes())+
				Math.abs(i.getiMusica()-j.getiMusica())+
				Math.abs(i.getiEspectaculos()-j.getiEspectaculos())+
				Math.abs(i.getiCiencia()-j.getiCiencia());
		return iSimilaridad;
	}

	// Eliminacion de aristas
	public void eliminarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = null;
		A[j][i] = null;
	}

	// Informa si existe la arista especificada
	public boolean existeArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		return A[i][j]!=null;
	}

	// Cantidad de vertices
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
}


