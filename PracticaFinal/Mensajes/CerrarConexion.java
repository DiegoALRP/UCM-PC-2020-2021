package Mensajes;

/**
 * CerrarConexion
 */
public class CerrarConexion extends Mensaje {

    public CerrarConexion(){
        this.tipo = TipoMensaje.CERRAR_CONEXION;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }

    
}