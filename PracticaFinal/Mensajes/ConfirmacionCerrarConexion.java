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
 * Clase Mensaje Confirmacion Cerrar Conexion.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodr�guez Pereira.
 *
 */
public class ConfirmacionCerrarConexion extends Mensaje{

    public ConfirmacionCerrarConexion(){
        this.tipo = TipoMensaje.CONFIRMACION_CERRAR_CONEXION;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }
    
}
