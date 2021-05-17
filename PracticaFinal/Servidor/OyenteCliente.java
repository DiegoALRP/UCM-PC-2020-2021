package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Mensajes.Mensaje;
import Mensajes.TipoMensaje;

/**
 * Universidad Complutense de Madrid.
 * Programaci�n Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Mar�a Albert Albiol.
 * 
 * Pr�ctica 5
 * 
 * Clase Oyente Cliente.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodr�guez Pereira.
 *
 */
public class OyenteCliente extends Thread {

    private Socket socket;
    private ObjectOutputStream fout;
    private ObjectInputStream fin;

    public OyenteCliente(Socket socket){

        this.socket = socket;
        try{
            this.fout = new ObjectOutputStream(socket.getOutputStream());
            this.fin = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException e){
            e.getStackTrace();
        } 
    }

    public void run() {

        while (true){
            // Inicializamos a un valor aleatorio
            Mensaje mensaje = new Conexion();

            try {
                mensaje = (Mensaje) fin.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }

            switch (mensaje.getTipo()) {
                case CONEXION:
                    /*
                     * Guardar informacion del usuario (en las tablas)
                     * Envio de mensaje confirmacion conexion fout 
                     */
                    break;
                case LISTA_USUARIOS:
                    /*
                     * Crear un mensaje con la informacion de usuarios en sistema
                     * Envio mensaje confirmacion lista usuarios fout
                     */
                    break;
                case CERRAR_CONEXION:
                    /*
                     * Eliminar informacion del usuario (en las tablas)
                     * Envio mensaje confirmacion cerrar conecion fout
                     * Break bucle
                     */
                    break;
                case PEDIR_FICHERO:
                    /*
                     * Buscar usuario que contiene el fichero
                     * Obtener fout
                     * envio mensaje MENSAJA_ENITIR_FICHERO por fout
                     */
                    break;
                case PREPARADO_CLIENTE_SERVIDOR:
                    /*
                     * Buscar fout (flujo del cliente al que hay que enviar la informacion)
                     * Envio fout mensaje MENSAJE_PREPARADO_SERVIDORCLIENTE
                     */
                    break;
                default:
                    break;
            }
        }
    }
}
