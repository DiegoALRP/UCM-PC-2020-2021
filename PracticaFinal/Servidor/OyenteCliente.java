package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Mensajes.Mensaje;
import Mensajes.TipoMensaje;

/**
 * Universidad Complutense de Madrid.
 * Programación Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira María Albert Albiol.
 * 
 * Práctica 5
 * 
 * Clase Oyente Cliente.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodríguez Pereira.
 *
 */
public class OyenteCliente extends Thread {

    private Socket socket;
    private ObjectOutputStream fout;
    private ObjectInputStream fin;

    public OyenteCliente(Socket socket){

    	try {
	        this.socket = socket;
	        this.fout = new ObjectOutputStream(socket.getOutputStream());
			this.fin = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void run() {

    	Mensaje m;
        while (true){

			try {
				m = (Mensaje) fin.readObject();

	            //Mensaje de Conexion
	            if (m.equals(TipoMensaje.CONEXION)){
	                //Realizar Conexion
	            }
	            else if (m.equals(TipoMensaje.LISTA_USUARIOS)){
	                
	            }
	            else if (m.equals(TipoMensaje.CERRAR_CONEXION)){
	                //Cerrar Conexion
	            }
	            else if (m.equals(TipoMensaje.PEDIR_FICHERO)){
	                //Avisar Emisor
	            }
	            else if (m.equals(TipoMensaje.PREPARADO_CLIENTE_SERVIDOR)){
	                //Avisar Receptor
	            }
	            /*
	            case (MENSAJE_CONEXION):
	                * Guardar informacion del usuario (en las tablas)
	                * Envio de mensaje confirmacion conexion fout 
	            */
	
	            /*
	            case (MENSAJE_LISTA_USUARIOS):
	                * Crear un mensaje con la informacion de usuarios en sistema
	                * Envio mensaje confirmacion lista usuarios fout
	            */
	
	            /*
	            case (MENSAJE_CERRAR_CONEXION):
	                * Eliminar informacion del usuario (en las tablas)
	                * Envio mensaje confirmacion cerrar conecion fout
	                * Break bucle
	            */
	
	            /*
	            case (MENSAJE_PEDIR_FICHERO):
	                * Buscar usuario que contiene el fichero
	                * Obtener fout
	                * envio mensaje MENSAJA_ENITIR_FICHERO por fout
	            */
	
	            /*
	            case (MENSAJE_PREPARADO_CLIENTESERVIDOR):
	                * Buscar fout (flujo del cliente al que hay que enviar la informacion)
	                * Envio fout mensaje MENSAJE_PREPARADO_SERVIDORCLIENTE
	            */
	            break;
	            
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
