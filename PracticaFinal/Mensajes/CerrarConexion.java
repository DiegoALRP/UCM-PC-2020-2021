package Mensajes;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase Mensaje Cerrar Conexion.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class CerrarConexion extends Mensaje {

    public CerrarConexion(String origen, String destino, String id){
        super(origen, destino, id);
        this.tipo = TipoMensaje.CERRAR_CONEXION;
    }
}