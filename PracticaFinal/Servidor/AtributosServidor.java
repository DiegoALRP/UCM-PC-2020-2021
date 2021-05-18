package Servidor;

import java.util.HashMap;

/**
 * AtributosServidor
 */
public class AtributosServidor {

    /**
    * tabla usuarios --- (id usuario, fin, fout)
    * tabla informacion --- (id usuario, [f1,f2,....]) #Informacion de Usarios de que ficheros contienen
    * tabla informacion mejorada --- (id usuario, fin, fout, [f1,f2,...])
    * direccion IP
    * puerto
    * serverSocket
     */
    
    // id usuario: Usuario(ip, puerto, fin, fout, [f1,f2,...])
    private HashMap<String, Usuario> tablaUsuarios;
    private String ip;
    private int puerto;
    // private ServerSocket serverSocket; // Evaluar por que hay que ponerlo

    public AtributosServidor(String ip, int puerto){
        this.ip = ip;
        this.puerto = puerto;
    };

    // public ArrayList<Fichero> getFicherosUsuario(){
        
    // }

    public HashMap<String, Usuario> getTablaUsuarios() {        
        // Hace lock

        return tablaUsuarios;
    }

    public String getIp() {
        return ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void agregarUsuario(Usuario u){
        
    }
}