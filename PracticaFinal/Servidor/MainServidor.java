package Servidor;

import java.io.IOException;

/**
 * Universidad Complutense de Madrid.
 * Programaci�n Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Mar�a Albert Albiol.
 * 
 * Pr�ctica 5
 * 
 * Clase Main Servidor.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodr�guez Pereira.
 *
 */
public class MainServidor {

	public static void main(String[] args) {
		
		Servidor servidor = new Servidor();
		try {
			servidor.main(args);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
