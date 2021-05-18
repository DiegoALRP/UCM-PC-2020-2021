package Cliente;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase Receptor.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class Receptor extends Thread {

	private Socket socket;
	private ObjectInputStream fin;
	private FileOutputStream fout;
	
	private String ip;
	private int puerto;
	
	private String filename;
	
	public Receptor() {
		
		
	}
	
	public void run() {
		
		try {
			
			this.socket = new Socket(ip, puerto);
			fin = new ObjectInputStream(socket.getInputStream());
			fout = new FileOutputStream(filename);
			
			//byte[] str = 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /*
     * Crear el socket
     * Acceder flujo entrada
     * Recibir informacion
     */
}