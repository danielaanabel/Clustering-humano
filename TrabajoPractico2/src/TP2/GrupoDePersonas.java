package TP2;

import java.util.ArrayList;

public class GrupoDePersonas {
	private ArrayList<Persona> personas;

	public GrupoDePersonas() {
		personas =new ArrayList<Persona>();
	}
	
	public void agregarPersona(String name,int iD, int iM, int iE, int iC) {
		Persona persona=new Persona(name, iD, iM, iE, iC);
		personas.add(persona);
	} 
	
	public void agregarPersona2(Persona p) {
		personas.add(p);
	} 
	
	public int cantPersonas() {
		return personas.size();
	}
	
	public Persona obtenerPersona(int p) {
	  return personas.get(p);
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setListaDePersonas(ArrayList<Persona> listaDePersonas) {
		this.personas = listaDePersonas;
	}


}
