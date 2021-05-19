package Servidor;

import java.io.IOException;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase Main Servidor.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class MainServidor {

	public static void main(String[] args) {
		
		if (args.length != 2) {
			
			System.out.println("Debes de introducir la ip y el puerto del servidor");
			System.out.println("Ejemplo: 192.192.0.21 500");
			return;
		}
		
		String ipServidor = args[0];
		int puertoServidor = Integer.parseInt(args[1]);
		Servidor servidor = new Servidor(ipServidor, puertoServidor);
		servidor.start();
		
		try {
			servidor.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
