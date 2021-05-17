package Cliente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import Mensajes.Mensaje;
import Mensajes.Conexion;
import Mensajes.ListaUsuarios;
import Mensajes.PedirFichero;
import Mensajes.CerrarConexion;

/**
 * Universidad Complutense de Madrid.
 * Programación Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira María Albert Albiol.
 * 
 * Práctica 5
 * 
 * Clase Cliente.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodríguez Pereira.
 *
 */
public class Cliente {
    
    private String ipCliente;
    private Socket socket;
    private String nombreCliente;
    private ObjectOutputStream fout;

    Cliente(){};

    public void main(String[] args){
        Globales variables = new Globales();
        Scanner scanner = new Scanner(System.in);

        /**
         * Obtener IP Cliente
         */
        try {  
            InetAddress ia = InetAddress.getLocalHost();  
            this.ipCliente = ia.getHostAddress(); 
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        System.out.println("Introduce nombre cliente:");
        this.nombreCliente = scanner.nextLine();

        /**
         * Crear socket con servidor
         */
        try {  
            this.socket = new Socket(variables.IPServidor, variables.PuertoServidor);
        }
        catch (IOException e) {
            e.printStackTrace(); 
            System.exit(-1);
        } 

        /**
         * Creamos el OutputStream
         */
        try {  
            this.fout = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException e) {
            e.printStackTrace(); 
            System.exit(-1);
        } 

        /**
         * Crear nuevo thread OyenteServidor para leer el socket
         */
        Thread hilo = new OyenteServidor(this.socket, this.nombreCliente, variables);
        try {
            hilo.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * Enviar Mensaje Conexion
         */
        Mensaje mensaje = new Conexion();
        try {  
            fout.writeObject(mensaje);
        }
        catch (IOException e) {
            e.printStackTrace(); 
            System.exit(-1);
        } 
        
        /**
         * Dar opciones
         */
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
                    mensaje = new ListaUsuarios();
                    try { fout.writeObject(mensaje); }
                    catch (IOException e) { e.printStackTrace(); } 
                    break;
                case 2:
                    // Enviar MENSAJE_PEDIR_FICHERO <fichero>
                    mensaje = new PedirFichero();
                    try { fout.writeObject(mensaje); }
                    catch (IOException e) { e.printStackTrace(); } 
                    break;
                case 3:
                    // MENSAJE_CERRAR_CONEXION
                    mensaje = new CerrarConexion();
                    try { fout.writeObject(mensaje); }
                    catch (IOException e) { e.printStackTrace(); }
                    break;
                default:
                    break;
            }        
        }

        scanner.close();
    }

    public String getIpCliente() { return this.ipCliente; }
}
