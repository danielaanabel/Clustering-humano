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
	
	public static ArrayList<ArrayList<String>> calcularGrupos(GrupoDePersonas listaDePersonas) {
		GrafoConPesos grafo=GrafoConPesos.construirGrafoCompleto(listaDePersonas.personas);
		grafo=AGM.algoritmoPrim(grafo);
		grafo.eliminarAristaMayorPeso();
		return obtenerGrupos(grafo,listaDePersonas.personas);
	}

	public static ArrayList<ArrayList<String>> obtenerGrupos(GrafoConPesos g,ArrayList<Persona> l) {
		ArrayList<ArrayList<String>> grupos=new ArrayList<ArrayList<String>>();
		ArrayList<String> grupo1= new ArrayList<String>();
		ArrayList<String> grupo2= new ArrayList<String>();

		for (int i = 0; i <l.size(); i++) {
			if(BFS.alcanzables(g, 0).contains(i)) 
				grupo1.add(l.get(i).getNombre());
			else 
				grupo2.add(l.get(i).getNombre());
		}
		grupos.add(grupo1);
		grupos.add(grupo2);
		return grupos;
	}	
	
	//metodos JSON
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
