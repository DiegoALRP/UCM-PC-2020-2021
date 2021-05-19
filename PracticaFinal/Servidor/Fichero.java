package Servidor;

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
 * Clase Fichero.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
@SuppressWarnings("serial")
public class Fichero implements Serializable {

    private String nombre;
    private String ruta;

    public Fichero(String nombre, String ruta) {
        
        this.nombre = nombre;
        this.ruta = ruta;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getRuta(){
        return this.ruta;
    }
}