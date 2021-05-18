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
public class Usuario implements Serializable {
    
	/**************** ATRIBUTOS ****************/
	private String idUsuario;
    private String ipUsuario;
    private int puerto;
    private ObjectOutputStream fout;
    private ObjectInputStream fin;
    // private int puerto;
    private ArrayList<Fichero> ficheros;

    
    /************** CONSTRUCTORA **************/
    public Usuario(String ip) {
        this.ipUsuario = ip;
        this.ficheros = new ArrayList<Fichero>();
    }

    
    /**************** METODOS ****************/
    public void addFichero(String nombreFichero, String rutaFichero) {

        this.ficheros.add(new Fichero(nombreFichero, rutaFichero));
    }
    
    
    /********** GETTERS AND SETTERS **********/
    public String getIdUsuario() {
    	return this.idUsuario;
    }
    
    public String getIpUsuario() {
    	return this.ipUsuario;
    }
    
    //TODO: Revisar si es mejor pasar por referencia o por valor
    public ArrayList<Fichero> getFicheros(){
    	return this.ficheros;
    }

    public void setFin(ObjectInputStream fin) {
        this.fin = fin;
    }

    public void setFout(ObjectOutputStream fout) {
        this.fout = fout;
    }

    public ObjectInputStream getFin() {
        return fin;
    }

    public ObjectOutputStream getFout() {
        return fout;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
