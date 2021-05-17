package Usuario;

<<<<<<< HEAD
/**
 * Fichero
=======
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
>>>>>>> 047f95959ab679ca2779bd15f41033e998567e45
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