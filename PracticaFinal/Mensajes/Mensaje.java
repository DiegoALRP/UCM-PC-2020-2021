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
 * Clase Abstracta Mensaje.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodríguez Pereira.
 *
 */
public abstract class Mensaje{
    /*
     * Lleva informacion sobre el tipo de mensaje, origen, ...
     */

    protected TipoMensaje tipo;
    protected String origen;
    protected String destino;
    
    public abstract TipoMensaje getTipo();
    public abstract String getOrigen();
    public abstract String getDestino();
}
