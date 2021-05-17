package Mensajes;
/**
 * PedirFichero
 */
public class PedirFichero extends Mensaje {

    public PedirFichero(){
        this.tipo = TipoMensaje.PEDIR_FICHERO;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }

    
}