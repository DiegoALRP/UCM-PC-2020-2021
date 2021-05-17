package Mensajes;
/**
 * EmitirFichero
 */
public class EmitirFichero extends Mensaje {

    public EmitirFichero(){
        this.tipo = TipoMensaje.EMITIR_FICHERO;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }

    
}