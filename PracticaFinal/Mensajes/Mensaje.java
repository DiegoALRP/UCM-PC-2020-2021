package Mensajes;

import java.io.Serializable;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase Abstracta Mensaje.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public abstract class Mensaje implements Serializable{
    /*
     * Lleva informacion sobre el tipo de mensaje, origen, ...
     */

    protected TipoMensaje tipo;
    protected String origen;
    protected String destino;
    protected String id;
    protected String userDest;
    
    public Mensaje (String origen, String destino, String id){
        this.origen = origen;
        this.destino = destino;
        this.id = id;
    }

    public TipoMensaje getTipo() {
    	return this.tipo;
    }
    public String getOrigen() {
    	return this.origen;
    }
    public String getDestino() {
    	return this.destino;
    }
    public String getId() {
    	return this.id;
    }
    public String getUserDest() {
		return userDest;
	}
}
