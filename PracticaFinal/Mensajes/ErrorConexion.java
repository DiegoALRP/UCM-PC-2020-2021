package Mensajes;

public class ErrorConexion extends Mensaje {

	public ErrorConexion(String origen, String destino, String id) {
		super(origen, destino, id);
		this.tipo = TipoMensaje.ERROR_CONEXION;
	}

}
