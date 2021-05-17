package Usuario;

public class Usuario implements Serializable {
    
    private String idUsuario;
    private String ipUsuario;
    private ArrayList<Fichero> ficheros;

    public Usuario(String id, String ip) {

        this.idUsuario = id;
        this.ipUsuario = ip;
        this.ficheros = new ArrayList<Fichero>()
    }

    public void addFichero(String nombreFichero, String rutaFichero) {

        this.ficheros.add(new Fichero())
    }
}
