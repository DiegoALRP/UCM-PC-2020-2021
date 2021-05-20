package Cliente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import javax.swing.JFileChooser;

import Mensajes.Mensaje;
import Mensajes.Conexion;
import Mensajes.EliminarFicheros;
import Mensajes.ListaUsuarios;
import Mensajes.PedirFichero;
import Servidor.Fichero;
import Mensajes.AgregarFicheros;
import Mensajes.CerrarConexion;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase Cliente.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class Cliente extends Thread {
    
    private String ipCliente;
    private String id;
    private OyenteServidor oyenteServidor;
    private ObjectOutputStream fout;
    private String ipServidor;
    private int puertoServidor;
    private Semaphore semCliente;
    
    private Scanner scanner;
    private Socket socket;
    private boolean conexcionActiva;

    public Cliente(String ipServidor, int puertoServidor, String ipCliente) {
    	
    	try {
    		
    		this.ipServidor = ipServidor;
        	this.puertoServidor = puertoServidor;
        	this.ipCliente = ipCliente;
        	
        	this.semCliente = new Semaphore(0);
			socket = new Socket(ipServidor, puertoServidor);
			this.fout = new ObjectOutputStream(socket.getOutputStream());
			scanner = new Scanner(System.in);
			this.conexcionActiva = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println("'Cliente:' Se ha creado cliente");
	}
    
    public void run() {
    	
    	try {
			
    		System.out.print("Introduzca nombre cliente: ");
    		this.id = scanner.nextLine();
    		while (this.id == null || this.id.isEmpty()) {
    			System.out.println("Debe introducir un nombre de usuario valido.");
    			this.id = scanner.nextLine();
    		}
    		
    		this.enviaMensaje(new Conexion(ipCliente, ipServidor, id, new ArrayList<Fichero>()));
    		this.oyenteServidor = new OyenteServidor(socket, this, semCliente, null);
    		this.oyenteServidor.start();
    		
    		//semCliente.acquire();
    		
    		while (this.conexcionActiva){
    			ComienzaMenu();
                /*System.out.println("Hola " + this.id + ", que quieres hacer?");
                System.out.println("1. Consultar lista usuarios");
                System.out.println("2. Pedir fichero");
                System.out.println("3. Salir");
                System.out.print("Tu opcion: ");
                
                int opcion = scanner.nextInt();
                System.out.println(opcion);*/
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /*public void main(String[] args){
        Globales variables = new Globales();
        Scanner scanner = new Scanner(System.in);

        /**
         * Obtener IP Cliente
         *//*
        try {  
            InetAddress ia = InetAddress.getLocalHost();  
            this.ipCliente = ia.getHostAddress(); 
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        System.out.println("Introduce nombre cliente:");
        this.id = scanner.nextLine();

        /**
         * Crear socket con servidor
         *//*
        try {  
            this.socket = new Socket(variables.IPServidor, variables.PuertoServidor);
        }
        catch (IOException e) {
            e.printStackTrace(); 
            System.exit(-1);
        } 

        /**
         * Creamos el OutputStream
         *//*
        try {  
            this.fout = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException e) {
            e.printStackTrace(); 
            System.exit(-1);
        } 

        /**
         * Crear nuevo thread OyenteServidor para leer el socket
         *//*
        Thread hiloOC = new OyenteServidor(this.socket, this, semCliente, variables);
        hiloOC.start();
        /*try { No hace falta esperar
            hilo.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*//*

        /**
         * Enviar Mensaje Conexion
         *//*
        Mensaje mensaje = new Conexion(this.ipCliente, variables.IPServidor, this.nombreCliente);
        try {  
            fout.writeObject(mensaje);
        }
        catch (IOException e) {
            e.printStackTrace(); 
            System.exit(-1);
        } 
        
        /**
         * Dar opciones
         *//*
        while (variables.conexionActiva){
            System.out.println("Hola " + this.nombreCliente + ", que quieres hacer?");
            System.out.println("1. Consultar lista usuarios");
            System.out.println("2. Pedir fichero");
            System.out.println("3. Salir");
            System.out.print("Tu opcion: ");
            
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    // Enviar MENSAJE_LISTA_USUARIOS
                    mensaje = new ListaUsuarios(ipCliente, ipServidor, nombreCliente);
                    try { fout.writeObject(mensaje); }
                    catch (IOException e) { e.printStackTrace(); } 
                    break;
                case 2:
                    // Enviar MENSAJE_PEDIR_FICHERO <fichero>
                	System.out.println("Introduce nommbre fichero: ");
                	String filename = scanner.nextLine();
                    mensaje = new PedirFichero(ipCliente, ipServidor, nombreCliente, filename);
                    try { fout.writeObject(mensaje); }
                    catch (IOException e) { e.printStackTrace(); } 
                    break;
                case 3:
                    // MENSAJE_CERRAR_CONEXION
                    mensaje = new CerrarConexion(ipCliente, ipServidor, nombreCliente);
                    try { fout.writeObject(mensaje); }
                    catch (IOException e) { e.printStackTrace(); }
                    break;
                default:
                    break;
            }        
        }

        scanner.close();
    }*/

    public void enviaMensaje(Mensaje m) {
    	
    	try {
			fout.writeObject(m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void ComienzaMenu() throws InterruptedException, IOException {
    	
		int op = 0;
		do {
			this.semCliente.acquire();
			op = menu();
			switch(op) {
				case 0: this.cerrarConexion(); return;
				case 1: this.ObtenerListaUsuarios(); break;
				case 2: this.compartirFicheros(this.solicitaFicherosCompartir()); break;
				case 3: this.dejarCompartirFicheros(this.solicitaFicherosDejarCompartir()); break;
				case 4: this.descargarFicheroBatch(this.solicitarFichero()); break;
			}
		} while(true);
	}
    
    public int menu() {
		String op;
		System.out.println("0. Salir.");
		System.out.println("1. Lista Usuarios.");
		System.out.println("2. Compartir ficheros.");
		System.out.println("3. Dejar de compartir ficheros.");
		System.out.println("4. Solicitar Fichero.");
		
		System.out.print("Opcion: ");
		op = scanner.nextLine();
		System.out.println();
		
		while(Integer.parseInt(op) < 0 || Integer.parseInt(op) > 4) {
			System.out.println("La opcion debe ser numerica entre 0 y 3.\n");
			System.out.print("Opcion: ");
			op = scanner.nextLine();
			System.out.println();
		}
		
		return Integer.parseInt(op);
	}
    
    public void cerrarConexion() throws IOException {
		fout.writeObject(new CerrarConexion(ipCliente, ipServidor, id));
	}
	
	public void ObtenerListaUsuarios() throws IOException {
		fout.writeObject(new ListaUsuarios(ipCliente, ipServidor, id));
	}
	
	public ArrayList<Fichero> solicitaFicherosCompartir() {
		ArrayList<Fichero> ficherosAnadir = new ArrayList<Fichero>();
		System.out.println("Introduce todos los ficheros que desea compartir (FIN): ");
		String fichero = scanner.nextLine();
		while(!fichero.equalsIgnoreCase("FIN")) {
			ficherosAnadir.add(new Fichero(fichero, fichero));
			fichero = scanner.nextLine();
		}
		return ficherosAnadir;
	}
	
	public void compartirFicheros(ArrayList<Fichero> ficherosAnadir) throws IOException {
		fout.writeObject(new AgregarFicheros(ipCliente, ipServidor, this.id, ficherosAnadir));
	}
	
	public ArrayList<Fichero> solicitaFicherosDejarCompartir() {
		ArrayList<Fichero> ficherosEliminar = new ArrayList<Fichero>();
		System.out.println("Introduce todos los ficheros que desea dejar de compartir (FIN): ");
		String fichero = scanner.nextLine();
		while(!fichero.equalsIgnoreCase("FIN")) {
			ficherosEliminar.add(new Fichero(fichero, fichero));
			fichero = scanner.nextLine();
		}
		return ficherosEliminar;
	}
	
	public void dejarCompartirFicheros(ArrayList<Fichero> ficherosEliminar) throws IOException {
		fout.writeObject(new EliminarFicheros(ipCliente, ipServidor, this.id, ficherosEliminar));
	}
	
	public String solicitarFichero() {
		System.out.print("Introduce el fichero que desea descargar: ");
		return scanner.nextLine();
	}
	
	public void descargarFicheroBatch(String fichero) throws IOException {
		fout.writeObject(new PedirFichero(ipCliente, ipServidor, this.id, fichero));
	}
	
	public void descargarFichero(String fichero) throws IOException {
		
		fout.writeObject(new PedirFichero(ipCliente, ipServidor, this.id, fichero));
	}
    
    public String getIpCliente() { return this.ipCliente; }
    
    public String getIdCliente() {
    	return this.id;
    }
    public void setIdCLiente(String id) {
    	this.id = id;
    }
    
    public String getIpServidor() {
    	return this.ipServidor;
    }
}
