package Servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Mensajes.Conexion;
import Mensajes.ConfirmacionCerrarConexion;
import Mensajes.Mensaje;
import Mensajes.TipoMensaje;
import Mensajes.ConfirmacionListaUsuarios;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase Oyente Cliente.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class OyenteClienteAntes extends Thread {

    private Socket socket;
    // private ObjectOutputStream fout;
    // private ObjectInputStream fin;
    private String ipCliente;
    private AtributosServidor atributos;
    private Usuario cliente;

    public OyenteClienteAntes(Socket socket, AtributosServidor atributos, String ipCliente) {
        this.atributos = atributos;
        this.cliente = new Usuario(ipCliente);
        // this.ipCliente = ipCliente;
        this.socket = socket;
        try{
            cliente.setFout(new ObjectOutputStream(socket.getOutputStream()));
            cliente.setFin(new ObjectInputStream(socket.getInputStream()));
        }
        catch (IOException e){
            e.getStackTrace();
        } 
    }

    public void run() {
        while (true) {
            Mensaje mensaje = null;
            ObjectInputStream fin = cliente.getFin();
            
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
                     * Envio de mensaje confirmacion conexion fout.
                     */
                    Conexion mConexion = // 
                    Mensaje respuesta = new Conexion(atributos.getIp(), this.ipCliente);
                    cliente.setIdUsuario(mensaje.getNombreUsuario());
                    atributos.agregarUsuario(cliente);
                    
                    break;
                case LISTA_USUARIOS:
                    /*
                     * Crear un mensaje con la informacion de usuarios en sistema
                     * Envio mensaje confirmacion lista usuarios fout
                     */
                    mensajeListaUsuarios(mensaje);
                    break;
                case CERRAR_CONEXION:
                    /*
                     * Eliminar informacion del usuario (en las tablas)
                     * Envio mensaje confirmacion cerrar conecion fout
                     * Break bucle
                     */
                    mensajeCerrarConexion(mensaje);
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
                    mensajePreparadoServidorCliente(m);
                    break;
                default:
                    break;
            }
        }
    }

    public void mensajeConexion() {


    }

    public void mensajeListaUsuarios(Mensaje m) {

        try {
            fout.writeObject(new ConfirmacionListaUsuarios(m.getDestino(), m.getOrigen(), atributos.getTablaUsuarios());   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mensajeCerrarConexion(Mensaje m) {

        System.out.println("'Servidor:' Cerrando Conexion, usuarioIp: " + m.getDestino());
        try {
            fout.writeObject(new ConfirmacionCerrarConexion(m.getDestino(), m.getOrigen()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Eliminar informacion de la tabla
    }

    public void mensajePedirFichero(Mensaje m) {

        String rutaFichero = new String();
        String idUsuario; //Hay que buscar el id del usuario que tiene el fichero solicitado
    }

    public void mensajePreparadoServidorCliente(Mensaje m) {

        //Creacion nuevo canal
        ObjectOutputStream 
    }
}
