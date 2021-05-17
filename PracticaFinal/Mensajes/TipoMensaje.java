package Mensajes;

/**
 * Universidad Complutense de Madrid.
 * Programaci�n Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Mar�a Albert Albiol.
 * 
 * Pr�ctica 5
 * 
 * Clase Enum Tipo Mensaje.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodr�guez Pereira.
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
    CONFIRMACION_CERRAR_CONEXION;
}
