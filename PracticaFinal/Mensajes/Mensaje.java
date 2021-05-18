package Mensajes;

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
public abstract class Mensaje{
    /*
     * Lleva informacion sobre el tipo de mensaje, origen, ...
     */

    protected TipoMensaje tipo;
    protected String origen;
    protected String destino;
    
    public Mensaje (String origen, String destino){
        this.origen = origen;
        this.destino = destino;
    }

    public abstract TipoMensaje getTipo();
    public abstract String getOrigen();
    public abstract String getDestino();
}
