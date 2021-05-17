package Usuario;

/**
 * Fichero
 */
public class Fichero implements Serializable {

    private String nombre;
    private String ruta;

    public Fichero(String nombre, String ruta) {
        
        this.nombre = nombre;
        this.ruta = ruta;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getRuta(){
        return this.ruta;
    }
}