package Mensajes;

/**
 * Universidad Complutense de Madrid.
 * Programaci�n Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Mar�a Albert Albiol.
 * 
 * Pr�ctica 5
 * 
 * Clase Abstracta Mensaje.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodr�guez Pereira.
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
