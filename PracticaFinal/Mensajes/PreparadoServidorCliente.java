package Mensajes;
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
