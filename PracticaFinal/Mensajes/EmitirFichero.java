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
 * Clase Mensaje Emitir Fichero.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class EmitirFichero extends Mensaje {

	private String filename;
	private String ruta_fichero;
	
    public EmitirFichero(String origen, String destino, String id, String filename, String ruta_fichero, String userDest){
        super(origen, destino, id);
        this.tipo = TipoMensaje.EMITIR_FICHERO;
        this.filename = filename;
        this.ruta_fichero = ruta_fichero;
        this.userDest = userDest;
    }
    
    public String getFilename() {
    	return this.filename;
    }
    public String getRutaFichero() {
    	return this.ruta_fichero;
    }
}