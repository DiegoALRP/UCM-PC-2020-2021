package Servidor;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase Usuario.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
@SuppressWarnings("serial")
public class Usuario implements Serializable {
    
	/**************** ATRIBUTOS ****************/
	private String idUsuario;
    private String ipUsuario;
    private ArrayList<Fichero> listaFicheros;

    
    /************** CONSTRUCTORAS **************/
    public Usuario(String id, String ip) {
    	this.idUsuario = id;
    	this.ipUsuario = ip;
        this.listaFicheros = new ArrayList<Fichero>();
    }
    
    public Usuario(String id, String ip, ArrayList<Fichero> listaFicheros) {
    	
    	super();
    	this.idUsuario = id;
    	this.ipUsuario = ip;
    	this.listaFicheros = new ArrayList<Fichero>(listaFicheros);
    }
    
    public Usuario(Usuario usuario) {
    	
    	this.idUsuario = usuario.idUsuario;
    	this.ipUsuario = usuario.ipUsuario;
    	this.listaFicheros = new ArrayList<Fichero>(usuario.listaFicheros);
    }

    
    /**************** METODOS ****************/
    public void addFichero(String nombreFichero, String rutaFichero) {

        this.listaFicheros.add(new Fichero(nombreFichero, rutaFichero));
    }
    
    public void removeFichero(String nombreFichero) {
    	
    	for (int i = 0; i < listaFicheros.size(); i++) {
    		if (listaFicheros.get(i).getNombre().equalsIgnoreCase(nombreFichero)) {
    			listaFicheros.remove(i);
    		}
    	}
    }
    
    /********** GETTERS AND SETTERS **********/
    public String getIdUsuario() {
    	return this.idUsuario;
    }
    
    public String getIpUsuario() {
    	return this.ipUsuario;
    }
    
    public ArrayList<Fichero> getFicheros(){
    	return this.listaFicheros;
    }
}
