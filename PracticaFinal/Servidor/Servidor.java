package Servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
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
    private int puerto;
    private ListaUsuarios listaUsuarios;
    private ListaFlujosUsuarios listaFlujosUsuarios;
    private ServerSocket socket;

    public Servidor(String ip, int puerto) {
    	
    	try {
	    	this.ip = ip;
	    	this.puerto = puerto;
	    	this.listaUsuarios = new ListaUsuarios();
	    	this.listaFlujosUsuarios = new ListaFlujosUsuarios();
			this.socket = new ServerSocket(this.puerto);
			System.out.println("'Servidor:' servidor iniciado");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /*
     * La informacion que se va a suministrar seran ficheros de texto.
     */

    public void run() {
    	
    	while(true) {
    		
    		try {
    			System.out.println("'Servidor': Esperando por nuevas conexiones...");
				Socket socketCliente = this.socket.accept();
				//OyenteCliente oc = new OyenteCliente(socketCliente, this);
				new OyenteCliente(socketCliente, this).start();
				//oc.start();
				System.out.println("Se ha establecido una nueva conexion!");
			} catch (IOException e) {
				e.printStackTrace();
			}
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
    
    public void agregarFicheros(String id, ArrayList<Fichero> listaFicheros) {
    	this.listaUsuarios.agregarFicheros(id, listaFicheros);
    }
    
    public void eliminarFicheros(String id, ArrayList<Fichero> listaFicheros) {
    	this.listaUsuarios.eliminarFicheros(id, listaFicheros);
    }
    
    public Usuario getUsuario(String nombreFichero) {
    	return this.listaUsuarios.getUsuario(nombreFichero);
    }
    
    public ObjectOutputStream getOutPutStream(String id) {
    	return this.listaFlujosUsuarios.getOutPutStream(id);
    }
    
    public String getIp() {
    	return this.ip;
    }
}
