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
 * Clase Mensaje Preparado Servidor Cliente.
 * 
 * @author
 * 	-Frederick Ernesto Borges Boronha.
 * 	-Diego Alejandro Rodr�guez Pereira.
 *
 */
public class PreparadoServidorCliente extends Mensaje{
    
    public PreparadoServidorCliente(){
        this.tipo = TipoMensaje.PREPARADO_SERVIDOR_CLIENTE;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }
    
}
