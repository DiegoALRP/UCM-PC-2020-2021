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
    
    public PreparadoServidorCliente(String origen, String destino, String id){
        super(origen, destino, id);
        this.tipo = TipoMensaje.PREPARADO_SERVIDOR_CLIENTE;
    }
}
