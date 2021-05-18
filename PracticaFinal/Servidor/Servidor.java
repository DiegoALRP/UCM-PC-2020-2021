package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import Usuario.Usuario;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesor:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase Servidor.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class Servidor {

    private int PUERTO;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public Servidor(){};

    /*
     * La informacion que se va a suministrar seran ficheros de texto.
     */

    public void main(){
        try {
            ServerSocket socket = new ServerSocket(PUERTO);
            while (true){

                System.out.println("'Servidor': Esperando por nuevas conexiones...");
                OyenteCliente oc = new OyenteCliente(socket.accept());
                oc.start();
                System.out.println("Se ha establecido una nueva conexion!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
