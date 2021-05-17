package Mensajes;
/**
 * ConfirmacionListaUsuarios
 */
public class ConfirmacionListaUsuarios extends Mensaje {

    public ConfirmacionListaUsuarios(){
        this.tipo = TipoMensaje.CONFIRMACION_LISTA_USUARIOS;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }

    
}