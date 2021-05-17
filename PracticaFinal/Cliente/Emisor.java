package Cliente;

import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Universidad Complutense de Madrid.
 * Programación Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira María Albert Albiol.
 * 
 * Práctica 5
 * 
 * Clase Emisor.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodríguez Pereira.
 *
 */
public class Emisor extends Thread {
	
	private Socket socket;
	private String nombreFichero;
	private FileInputStream fin;
	private ObjectOutputStream fout;
	private ServerSocket serverSocket;
	
	public Emisor(ServerSocket serverSocket, String nombreFichero) {
		
		this.serverSocket = serverSocket;
		this.nombreFichero = nombreFichero;
	}
	
	public void run() {
		
		try {
			
			//Creacion del Server Socket y aceptamos (esperamos por el receptor)
			socket = serverSocket.accept();
			//this.socket = new Socket();
			//TODO: capaz hay que hacer un serverSocket.accept();
			fout = new ObjectOutputStream(socket.getOutputStream());
			
			//Acceder al flujo de entrada
			fin = new FileInputStream(nombreFichero);
			
			//Escribir informacion por salida
			Scanner sc = new Scanner(fin);
			while (sc.hasNextLine()) {
				
				fout.writeBytes(sc.nextLine());
			}
			
			fin.close();
			fout.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println("'Emisor:' Ha fallado la emision del fichero");
			e.printStackTrace();
			return;
		}
	}
	
    /*
     * Crear ServerSocket
     * Accept
     * Acceder flujo entrada
     * Escribir informacion por salida
     */
}
