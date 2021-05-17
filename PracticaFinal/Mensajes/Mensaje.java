package Mensajes;
public abstract class Mensaje{
    /*
     * Lleva informacion sobre el tipo de mensaje, origen, ...
     */

    protected TipoMensaje tipo;
    protected String origen;
    protected String destino;
    
    public abstract TipoMensaje getTipo();
    public abstract String getOrigen();
    public abstract String getDestino();
}
