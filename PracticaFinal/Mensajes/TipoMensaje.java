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
 * Clase Enum Tipo Mensaje.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public enum TipoMensaje{
	
    CONEXION,
    CONFIRMAR_CONEXION,
    CERRAR_CONEXION,
    LISTA_USUARIOS,
    CONFIRMACION_LISTA_USUARIOS,
    PEDIR_FICHERO,
    EMITIR_FICHERO,
    PREPARADO_CLIENTE_SERVIDOR,
    CONFIRMACION,
    PREPARADO_SERVIDOR_CLIENTE,
    CONFIRMACION_CERRAR_CONEXION,
    ERROR_CONEXION;
}
