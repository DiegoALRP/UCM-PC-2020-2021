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
 * Clase Mensaje Preparado Servidor Cliente.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class PreparadoServidorCliente extends Mensaje{
    
    public PreparadoServidorCliente(String origen, String destino){
        super(origen, destino);
        this.tipo = TipoMensaje.PREPARADO_SERVIDOR_CLIENTE;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }
    
}
