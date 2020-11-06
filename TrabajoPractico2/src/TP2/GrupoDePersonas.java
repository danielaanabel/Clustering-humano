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
	
	public Persona obtenerPersona(int p) {
	  return personas.get(p);
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setListaDePersonas(ArrayList<Persona> listaDePersonas) {
		this.personas = listaDePersonas;
	}
	
	
	public String generarJSONPretty(){
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String json= gson.toJson(this);

		return json;
	}

	public void guardarJSON(String jsonParaGuardar,String archivoDestino){
		try 
		{
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

		try{
			BufferedReader br= new BufferedReader(new FileReader(archivo));
			ret=gson.fromJson(br, GrupoDePersonas.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
