package Usuario;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Universidad Complutense de Madrid.
 * Programaci�n Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Mar�a Albert Albiol.
 * 
 * Pr�ctica 5
 * 
 * Clase Usuario.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodr�guez Pereira.
 *
 */
public class Usuario implements Serializable {
    
	/**************** ATRIBUTOS ****************/
	private static final long serialVersionUID = 1L;
	private String idUsuario;
    private String ipUsuario;
    private ArrayList<Fichero> ficheros;

    
    /************** CONSTRUCTORA **************/
    public Usuario(String id, String ip) {

        this.idUsuario = id;
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
}
