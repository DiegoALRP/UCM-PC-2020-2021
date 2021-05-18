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
 * Clase Mensaje Confirmacion.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class Confirmacion extends Mensaje{

    public Confirmacion(String origen, String destino){
        super(origen, destino);
        this.tipo = TipoMensaje.CONFIRMACION;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }
    
}
