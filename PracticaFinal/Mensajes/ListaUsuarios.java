package Mensajes;
/**
 * ListaUsuarios
 */
public class ListaUsuarios extends Mensaje {

    public ListaUsuarios(){
        this.tipo = TipoMensaje.LISTA_USUARIOS;
    }

    @Override
    public TipoMensaje getTipo() { return this.tipo; }

    @Override
    public String getOrigen() { return this.origen; }

    @Override
    public String getDestino() { return this.destino; }

    
}