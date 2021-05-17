package Mensajes;

/**
 * Conexion
 */
public class Conexion extends Mensaje {

    public Conexion(){
        this.tipo = TipoMensaje.CONEXION;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }

    
}