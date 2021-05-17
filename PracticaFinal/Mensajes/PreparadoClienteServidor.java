package Mensajes;
/**
 * PreparadoClienteServidor
 */
public class PreparadoClienteServidor extends Mensaje {

    public PreparadoClienteServidor(){
        this.tipo = TipoMensaje.PREPARADO_CLIENTE_SERVIDOR;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }

    
}