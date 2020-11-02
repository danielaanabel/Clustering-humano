package TP2;



public class Persona {
	
	private String nombre;
	private int iDeportes;
	private int iMusica;
	private int iEspectaculos;
	private int iCiencia;
	
	public Persona(String name,int iD, int iM, int iE, int iC) {
		setNombre(name);
		setiDeportes(iD);
		setiMusica(iM);
		setiEspectaculos(iE);
		setiCiencia(iC);
	}
	
	//agregar IREP para que solo reciban valores entre 1 y 5
	public int getiDeportes() {
		return iDeportes;
	}

	public void setiDeportes(int iDeportes) {
		this.iDeportes = iDeportes;
	}

	public int getiMusica() {
		return iMusica;
	}

	public void setiMusica(int iMusica) {
		this.iMusica = iMusica;
	}

	public int getiEspectaculos() {
		return iEspectaculos;
	}

	public void setiEspectaculos(int iEspectaculos) {
		this.iEspectaculos = iEspectaculos;
	}

	public int getiCiencia() {
		return iCiencia;
	}

	public void setiCiencia(int iCiencia) {
		this.iCiencia = iCiencia;
	}

	//Hacer el IREP de la longitud del nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
