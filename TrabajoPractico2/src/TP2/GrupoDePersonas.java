package TP2;

import java.util.ArrayList;

public class GrupoDePersonas {
	private ArrayList<Persona> listaDePersonas;

	public GrupoDePersonas() {
		listaDePersonas =new ArrayList<Persona>();
	}
	
	public void agregarPersona(Persona p) {
		listaDePersonas.add(p);
	}
	
	public int cantPersonas() {
		return listaDePersonas.size();
	}

	public ArrayList<Persona> getListaDePersonas() {
		return listaDePersonas;
	}

	public void setListaDePersonas(ArrayList<Persona> listaDePersonas) {
		this.listaDePersonas = listaDePersonas;
	}
	
	
	

}
