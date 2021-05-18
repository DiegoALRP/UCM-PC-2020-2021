package Cliente;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import Mensajes.ConfirmacionListaUsuarios;
import Mensajes.EmitirFichero;
import Mensajes.Mensaje;
import Mensajes.PreparadoClienteServidor;
import Servidor.Fichero;
import Servidor.Usuario;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase OyenteServidor.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class OyenteServidor extends Thread {

    private Socket socket;
    private String nombreCliente;
    private Globales variables;
    private ObjectInputStream fin;
    private Cliente cliente;
    private Semaphore semCliente;

    OyenteServidor(Socket socket, Cliente cliente, Semaphore semCliente, Globales variables){
        this.socket = socket;
        this.nombreCliente = nombreCliente;
        this.variables = variables;
    }

    public void run() {
        //while (variables.conexionActiva){
    	while (true) {
    		Mensaje m;
    		try {
				
    			m = (Mensaje) fin.readObject();
    			
    			switch (m.getTipo()) {
				case CONFIRMACION: {
					System.out.println("'OyenteServidor:' conexion con servidor establecida ");
					//Revisar si hay que llamar al thread de cliente
					this.semCliente.release();
					break;
				}
				case CONFIRMACION_LISTA_USUARIOS: {
					mensajeConfirmacionListaUsuarios(m);
					break;
				}
				case EMITIR_FICHERO: {
					emitirFichero((EmitirFichero) m);
				}

				default:
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
            // Mensaje m = (Mensaje) fin.readObject();
            /*
            case (MENSAJE_CONFIRMACION_CONEXION):
                * Imprimir "Conexion establecida" por std out.
            */

            /*
            case (MENSAJE_CONFIRMACION_LISTA_USUARIOS):
                * Imprimir la lista de clientes por std out.
            */

            /*
            case (MENSAJE_EMITIR_FICHERO):
                (Nos llega nombre de cliente C1 e informacion pedida 3)
                * Enviar mensaje MENSAJE_PREPARADO_CLIENTESERVIDOR a al oyente.
                * Crear proceso EMISOR y esperar en accept la conexion.
            */

            /*
            case (MENSAJE_PREPARADO_SERVIDORCLIENTE):
                (Llega direccion IP y puerto del propietario del fichero)
                * Crear proceso RECEPTOR.
            */

            /*
            case (MENSAJE_CONFIRMACION_CERRAR_CONEXION):
                * Imprimir "Adios" por std out.
                * variables.conexionActiva = False
            */
        }
    }
    
    private void mensajeConfirmacionListaUsuarios(Mensaje m) {
    	
    	System.out.println("'OyenteServidor:' se ha recibido informacion de los usuarios");
		ArrayList<Usuario> listaUsuarios = ((ConfirmacionListaUsuarios) m).getListaUsuarios();
		for (Usuario user : listaUsuarios) {
			System.out.println("ID Usuario: " + user.getIdUsuario());
			for (Fichero fichero : user.getFicheros()) {
				System.out.println(fichero.getNombre());
			}
		}
		this.semCliente.release();
    }
    
    public void emitirFichero(EmitirFichero m) throws IOException {
    	ServerSocket socket = new ServerSocket(0); //Con 0 busca un puerto disponible automaticamente
		socket.setReuseAddress(true);
		Mensaje mPreparado = new PreparadoClienteServidor(m.getUserDest(), m.getOrigen(), nombreCliente, cliente.getIpCliente(), socket.getLocalPort(), m.getFilename());
		cliente.enviaMensaje(m);
		Emisor emisor = new Emisor(socket, m.getRutaFichero(), semCliente);
		emisor.start();
    }
}