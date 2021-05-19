package Cliente;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase Main Cliente.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class MainCliente {

    public static void main(String[] args){

    	if (args.length != 3) {
    		System.out.println("Debes de introducir: \n(1)ip del servidor \n(2)puerto del servidor \n(3)ip cliente");
    	}
    	else {
    		String ipServidor = args[0];
    		int puertoServidor = Integer.parseInt(args[1]);
    		String ipCliente = args[2];
    		//int numPuertos = args[3];
    		
    		Cliente cliente = new Cliente(ipServidor, puertoServidor, ipCliente);
    		cliente.start();
    	}
    }
}