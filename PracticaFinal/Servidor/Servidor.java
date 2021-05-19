package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
public class Servidor extends Thread {
	
	private String ip;
    private int puerto = 500;
    private ListaUsuarios listaUsuarios;
    private ListaFlujosUsuarios listaFlujosUsuarios;

    public Servidor(){};

    /*
     * La informacion que se va a suministrar seran ficheros de texto.
     */

    public void main(){
        try {
            ServerSocket socket = new ServerSocket(puerto);
            AtributosServidor atributos = new AtributosServidor(socket.getInetAddress().getHostAddress(), socket.getLocalPort());
            while (true){
                System.out.println("'Servidor': Esperando por nuevas conexiones...");
                Socket s = socket.accept();
                //OyenteCliente oc = new OyenteCliente(s, atributos, s.getRemoteSocketAddress().toString());
                OyenteCliente oc = new OyenteCliente(s, this);
                oc.start();
                System.out.println("Se ha establecido una nueva conexion!");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean idValido(String id) {
		return this.listaUsuarios.idValido(id);
	}
    
    public void addUsuario(Usuario usuario, FlujosUsuario flujosUsuario) {
    	
    	this.listaUsuarios.addUsuario(usuario);
    	this.listaFlujosUsuarios.addFlujo(flujosUsuario);
    }
    
    public void deleteUsuario(String id) {
    	
    	this.listaUsuarios.deleteUsuario(id);
    	this.listaFlujosUsuarios.deleteUsuario(id);
    }
    
    public ArrayList<Usuario> getListaUsuarios(){
    	
    	return this.listaUsuarios.getListaUsuarios();
    }
    
    public String getIp() {
    	return this.ip;
    }
}
