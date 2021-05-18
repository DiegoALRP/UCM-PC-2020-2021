package Usuario;

import java.io.Serializable;

/**
 * Universidad Complutense de Madrid.
 * Programación Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira María Albert Albiol.
 * 
 * Práctica 5
 * 
 * Clase Fichero.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodríguez Pereira.
 *
 */
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