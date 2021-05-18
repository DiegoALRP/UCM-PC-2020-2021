package Cliente;
import java.net.Socket;

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

    OyenteServidor(Socket socket, String nombreCliente, Globales variables){
        this.socket = socket;
        this.nombreCliente = nombreCliente;
        this.variables = variables;
    }

    public void run() {
        while (variables.conexionActiva){
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
}