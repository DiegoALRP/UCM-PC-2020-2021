package Cliente;

import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase Emisor.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class Emisor extends Thread {
	
	private Socket socket;
	private String nombreFichero;
	private FileInputStream fin;
	private ObjectOutputStream fout;
	private ServerSocket serverSocket;
	
	private Semaphore semEmisor;
	
	public Emisor(ServerSocket serverSocket, String nombreFichero, Semaphore semEmisor) {
		
		this.serverSocket = serverSocket;
		this.nombreFichero = nombreFichero;
		this.semEmisor = semEmisor;
	}
	
	public void run() {
		
		try {
			
			this.semEmisor.acquire();
			//Creacion del Server Socket y aceptamos (esperamos por el receptor)
			socket = serverSocket.accept();
			//this.socket = new Socket();
			//TODO: capaz hay que hacer un serverSocket.accept();
			fout = new ObjectOutputStream(socket.getOutputStream());
			
			//Acceder al flujo de entrada
			fin = new FileInputStream(nombreFichero);
			
			//Escribir informacion por salida
			byte[] bytes = new byte[8*1024];
			int count;
			while ((count = fin.read(bytes)) > 0) {
				fout.write(bytes, 0, count);
			}
			
			fin.close();
			fout.close();
			socket.close();
			this.semEmisor.release();
			
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
