package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Mensajes.AgregarFicheros;
import Mensajes.Conexion;
import Mensajes.ConfirmacionAgregarFicheros;
import Mensajes.ConfirmacionCerrarConexion;
import Mensajes.ConfirmacionConexion;
import Mensajes.ConfirmacionEliminarFicheros;
import Mensajes.ConfirmacionListaUsuarios;
import Mensajes.EliminarFicheros;
import Mensajes.EmitirFichero;
import Mensajes.ErrorConexion;
import Mensajes.ErrorPedirFichero;
import Mensajes.Mensaje;
import Mensajes.PedirFichero;
import Mensajes.PreparadoClienteServidor;
import Mensajes.PreparadoServidorCliente;

public class OyenteCliente extends Thread {
	
	private Servidor servidor;
	private Socket socket;
	private ObjectInputStream fin;
	private ObjectOutputStream fout;
	
	public OyenteCliente(Socket socket, Servidor servidor) {
		
		this.socket = socket;
		this.servidor = servidor;
		try {
			this.fin = new ObjectInputStream(this.socket.getInputStream());
			this.fout = new ObjectOutputStream(this.socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		try {
			
			Mensaje m = null;
			while (true) {
				
				m = (Mensaje) this.fin.readObject();
				
				switch (m.getTipo()) {
				case CONEXION:
					mensajeConexion((Conexion) m);
					break;
				case LISTA_USUARIOS:
					mensajeListaUsuarios(m);
					break;
				case AGREGAR_FICHEROS:
					mensajeAgregarFicheros((AgregarFicheros) m);
					break;
				case ELIMINAR_FICHEROS:
					mensajeEliminarFicheros((EliminarFicheros) m);
				case PEDIR_FICHERO:
					mensajePedirFichero((PedirFichero) m);
					break;
				case PREPARADO_CLIENTE_SERVIDOR:
					mensajePreparadoClienteServidor((PreparadoClienteServidor) m);
					break;
				case CERRAR_CONEXION:
					mensajeCerrarConexion(m);
					return;
				default:
					break;
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void mensajeConexion(Conexion m) throws IOException {
		
		if (servidor.idValido(m.getId())) {
			fout.writeObject(new ErrorConexion(this.servidor.getIp(), m.getOrigen(), "none"));
		}
		else {
			System.out.println("'OyenteCliente:' se ha conectado usuario: " + m.getId());
			servidor.addUsuario(new Usuario(m.getId(), m.getOrigen(), m.getListaFicheros()), new FlujosUsuario(m.getId(), this.fin, this.fout));
			this.fout.writeObject(new ConfirmacionConexion(this.servidor.getIp(), m.getOrigen(), "none"));
		}
	}

	private void mensajeListaUsuarios(Mensaje m) throws IOException {
		
		System.out.println("'OyenteCliente:' el usuario " + m.getId() + " ha solicitado la lista de usuarios");
		this.fout.writeObject(new ConfirmacionListaUsuarios(this.servidor.getIp(), m.getOrigen(), this.servidor.getListaUsuarios(), m.getId()));
	}
	
	private void mensajeAgregarFicheros(AgregarFicheros m) throws IOException {
		
		System.out.println("'OyenteCliente:' el usuario " + m.getId() + " ha compartido nuevos ficheros");
		this.servidor.agregarFicheros(m.getId(), m.getListaFicheros());
		this.fout.writeObject(new ConfirmacionAgregarFicheros(this.servidor.getIp(), m.getOrigen(), "none"));
	}
	
	private void mensajeEliminarFicheros(EliminarFicheros m) throws IOException {
		
		System.out.println("'OyenteCliente:' el usuario " + m.getId() + " ha dejado de compartir ficheros");
		this.servidor.eliminarFicheros(m.getId(), m.getListaFicheros());
		this.fout.writeObject(new ConfirmacionEliminarFicheros(this.servidor.getIp(), m.getOrigen(), m.getId()));
	}
	
	private void mensajePedirFichero(PedirFichero m) throws IOException {
		
		System.out.println("'OyenteCliente:' el usuario " + m.getId() + "ha solicitdado un fichero");
		Usuario user = this.servidor.getUsuario(m.getFilename());
		if (user == null) {
			this.fout.writeObject(new ErrorPedirFichero(this.servidor.getIp(), m.getOrigen(), "none"));
		}
		else {
			
			String rutaFichero = new String();
			for (Fichero fichero : user.getFicheros()) {
				if (fichero.getNombre().equalsIgnoreCase(m.getFilename())) {
					rutaFichero = fichero.getRuta();
					break;
				}
			}
			
			ObjectOutputStream fout_e = this.servidor.getOutPutStream(user.getIdUsuario());
			fout_e.writeObject(new EmitirFichero(m.getDestino(), m.getOrigen(), m.getId(), m.getFilename(), rutaFichero, m.getId()));
		}
	}
	
	private void mensajePreparadoClienteServidor(PreparadoClienteServidor m) throws IOException {
		
		ObjectOutputStream fout_p = this.servidor.getOutPutStream(m.getId());
		fout_p.writeObject(new PreparadoServidorCliente(m.getOrigen(), m.getDestino(), m.getId(), m.getMyIp(), m.getPuerto()));
	}
	
	private void mensajeCerrarConexion(Mensaje m) throws IOException {
		
		System.out.println("'OyenteCliente:' el usuario " + m.getId() + " se ha desconectado");
		this.servidor.deleteUsuario(m.getId());
		this.fout.writeObject(new ConfirmacionCerrarConexion(this.servidor.getIp(), m.getOrigen(), m.getId()));
		this.fout.close();
	}
}
