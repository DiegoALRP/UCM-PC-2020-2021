package Mensajes;
public class Confirmacion extends Mensaje{

    public Confirmacion(){
        this.tipo = TipoMensaje.CONFIRMACION;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }
    
}
