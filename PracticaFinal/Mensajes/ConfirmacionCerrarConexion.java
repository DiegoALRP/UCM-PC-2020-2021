package Mensajes;
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
