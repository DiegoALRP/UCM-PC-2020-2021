package Mensajes;

/**
 * Universidad Complutense de Madrid.
 * Programación Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira María Albert Albiol.
 * 
 * Práctica 5
 * 
 * Clase Mensaje Conexion.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodríguez Pereira.
 *
 */
public class Conexion extends Mensaje {

    public Conexion(){
        this.tipo = TipoMensaje.CONEXION;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }

    
}