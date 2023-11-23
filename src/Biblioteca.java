import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Biblioteca {
    private Map<Libro, Integer> libros;
    private Set<Usuario> usuarios;
    private ArrayList<Alquiler> alquileres;

    public Biblioteca() {
        this.libros = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {
        libros.put(libro, 1);
    }
}

