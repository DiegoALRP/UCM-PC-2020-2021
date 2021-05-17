package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import Usuario.Usuario;

/**
 * Universidad Complutense de Madrid.
 * Programación Concurrente.
 * Grupo A 2020-2021.
 * Profesor:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Práctica 5
 * 
 * Clase Servidor.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodríguez Pereira.
 *
 */
public class Servidor extends Thread {

    private int PUERTO;
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public Servidor(){};

    /*
     * La informacion que se va a suministrar seran ficheros de texto.
     */

    public void main(String[] args) throws IOException{
        // while (true){
            // s = ServerSocket.accept();
            // (new OC(s)).start();
        //}

        try {
            ServerSocket socket = new ServerSocket(PUERTO);
            while (true){

                System.out.println("'Servidor': Esperando por nuevas conexiones...");
                new OyenteCliente(socket.accept()).start();
                System.out.println("¡Se ha establecido una nueva conexion!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
