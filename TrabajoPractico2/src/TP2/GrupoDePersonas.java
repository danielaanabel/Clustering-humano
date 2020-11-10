package TP2;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class GrupoDePersonas {
	private ArrayList<Persona> personas;
	
	public GrupoDePersonas() {
		personas =new ArrayList<Persona>();
	}
	
	public void agregarPersona(String name,int iD, int iM, int iE, int iC) {
		Persona persona=new Persona(name, iD, iM, iE, iC);
		personas.add(persona);
	} 	
	
	public int cantPersonas() {
		return personas.size();
	}
	
	public String obtenerPersona(int p) {
	  return personas.get(p).getNombre();
	}
	
	public boolean existePersona(String name) {
		for (Persona p : personas) {
			if(p.getNombre().equals(name))
				return true;
		}
		return false;
	}
	
	public void anexarListaPersonas(GrupoDePersonas grupoDePersonas) {
		personas.addAll(grupoDePersonas.personas);
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	
	//metodos JSON
	public String generarJSONPretty(){
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String json= gson.toJson(this);

		return json;
	}

	public void guardarJSON(String jsonParaGuardar,String archivoDestino) {
		try {
			FileWriter writer=new FileWriter(archivoDestino);
			writer.write(jsonParaGuardar);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static GrupoDePersonas leerJSON(String archivo) {

		Gson gson=new Gson();
		GrupoDePersonas ret=null;

		try {
			BufferedReader br= new BufferedReader(new FileReader(archivo));
			ret=gson.fromJson(br, GrupoDePersonas.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
