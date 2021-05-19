package Mensajes;

import java.util.ArrayList;

import Servidor.Fichero;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase Mensaje Conexion.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class Conexion extends Mensaje {

	private ArrayList<Fichero> listaFicheros;
	
    public Conexion(String origen, String destino, String id, ArrayList<Fichero> listaFicheros) {
        super(origen, destino, id);
        this.tipo = TipoMensaje.CONEXION;
        this.listaFicheros = listaFicheros;
    }
    
    public ArrayList<Fichero> getListaFicheros() {
    	return this.listaFicheros;
    }
}