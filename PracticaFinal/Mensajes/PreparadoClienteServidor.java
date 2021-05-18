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
 * Clase Mensaje Preparado Cliente Servidor.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class PreparadoClienteServidor extends Mensaje {

	private String myIp;
	private int puerto;
	private String filename;
	
    public PreparadoClienteServidor(String userDest, String destino, String id, String myIp, int puerto, String filename) {
        super(myIp, destino, id);
        this.tipo = TipoMensaje.PREPARADO_CLIENTE_SERVIDOR;
        this.userDest = userDest;
        this.myIp = myIp;
        this.puerto = puerto;
        this.filename = filename;
    }

	public String getMyIp() {
		return myIp;
	}

	public int getPuerto() {
		return puerto;
	}

	public String getFilename() {
		return filename;
	}
}