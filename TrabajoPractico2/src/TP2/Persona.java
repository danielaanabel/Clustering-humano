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

	public int getiDeportes() {
		return iDeportes;
	}

	public void setiDeportes(int iDeportes) {
		if(iDeportes<1 || iDeportes>5)
			throw new RuntimeException("Se deben ingresar valores entre 1 y 5");
		this.iDeportes = iDeportes;
	}

	public int getiMusica() {
		return iMusica;
	}

	public void setiMusica(int iMusica) {
		if(iMusica<1 || iMusica>5)
			throw new RuntimeException("Se deben ingresar valores entre 1 y 5");
		this.iMusica = iMusica;
	}

	public int getiEspectaculos() {
		return iEspectaculos;
	}

	public void setiEspectaculos(int iEspectaculos) {
		if(iEspectaculos<1 || iEspectaculos>5)
			throw new RuntimeException("Se deben ingresar valores entre 1 y 5");
		this.iEspectaculos = iEspectaculos;
	}

	public int getiCiencia() {
		return iCiencia;
	}

	public void setiCiencia(int iCiencia) {
		if(iCiencia<1 || iCiencia>5)
			throw new RuntimeException("Se deben ingresar valores entre 1 y 5");
		this.iCiencia = iCiencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre.length()<3 || nombre.length()>12)
			throw new RuntimeException("�Debe ingresar nombres entre 2 y 12 letras!");
		this.nombre = nombre;
	}
	
}
