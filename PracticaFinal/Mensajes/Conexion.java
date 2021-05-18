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
 * Clase Mensaje Conexion.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class Conexion extends Mensaje {

    private String nombreCliente;

    public Conexion(String origen, String destino, String nombreCliente) {
        super(origen, destino);
        this.tipo = TipoMensaje.CONEXION;
        this.nombreCliente = nombreCliente;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }

    public String getNombreCliente() { return this.nombreCliente; }

    
}