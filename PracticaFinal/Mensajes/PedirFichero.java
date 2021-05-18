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
 * Clase Mensaje Pedir Fichero.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class PedirFichero extends Mensaje {

	private String filename;
	
    public PedirFichero(String origen, String destino, String id, String filename){
        super(origen, destino, id);
        this.tipo = TipoMensaje.PEDIR_FICHERO;
        this.filename = filename;
    }
    
    public String getFilename() {
    	return this.filename;
    }
}