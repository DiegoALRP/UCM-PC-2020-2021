package Mensajes;
/**
 * ConfirmacionConexion
 */
public class ConfirmacionConexion extends Mensaje{

    public ConfirmacionConexion(){
        this.tipo = TipoMensaje.CONFIRMAR_CONEXION;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }

    
}