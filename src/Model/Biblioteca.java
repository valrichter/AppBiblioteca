package Model;

import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {
    private Set<Libro> libros;
    private Map<Integer, Usuario> usuarios; // DNI

    public Biblioteca() {
        this.libros = new HashSet<>();
        this.usuarios = new HashMap<>();
    }

    // Método para registrar un nuevo usuario
    public void registrarUsuario(Usuario usuario) {

        // Verificar si el usuario ya está registrado
        if (usuarios.containsKey(usuario.getDni())) {
            System.out.println("Usuario ya registrado -> '" + usuario + "' ");
        } else {
            // Crear un nuevo usuario y agregarlo a la lista
            String nombreUsuario = usuario.getNombre();
            String apellidoUsuario = usuario.getApellido();
            Integer dniUsuario = usuario.getDni();

            Usuario nuevoUsuario = new Usuario(dniUsuario, nombreUsuario, apellidoUsuario);
            usuarios.put(dniUsuario, nuevoUsuario);
            System.out.println("Usuario registrado -> '" + nuevoUsuario + "'");
        }
    }

    public void agregarLibro(Libro nuevoLibro) {
        libros.add(nuevoLibro);
        System.out.println("Libro agregado -> '" + nuevoLibro + "'");
    }

    public void eliminarLibro(Libro libro) {
        // Usar un iterador para evitar ConcurrentModificationException
        libros.remove(libro);
        System.out.println("Libro eliminado -> '" + libro + "'");
    }

    public Libro alquilarLibroAUsuario(Libro libro, Integer dniUsuario) {
        // Recorrer los libros para ver si el titulo deseo esta alquilado
        if (!usuarios.containsKey(dniUsuario)) {
            throw new Error("Usted no esta registrado");
        }

        if (!libros.contains(libro)) {
            throw new Error("Libro no existe");
        }

        Libro libroEncontrado = libros.stream()
                .filter(l -> l.getTitulo().equals(libro.getTitulo()))
                .findFirst()
                .orElse(null);

        assert libroEncontrado != null;
        if (libroEncontrado.isAlquilado()) {
            throw new Error("Libro alquilado");
        }

        libros.remove(libroEncontrado);
        libroEncontrado.setAlquilado(true);
        libros.add(libroEncontrado);

        return libroEncontrado;
    }

    public void devolverLibroDeUsuario(Libro libro){
        Libro libroEncontrado = libros.stream()
                .filter(l -> l.getTitulo().equals(libro.getTitulo()))
                .findFirst()
                .orElse(null);
        assert libroEncontrado != null;
        libros.remove(libroEncontrado);
        libroEncontrado.setAlquilado(false);
        libros.add(libroEncontrado);
    }

    public Libro buscarPorTitulo (String titulo) {
        return libros.stream()
                .filter(l -> l.getTitulo().toLowerCase().equals(titulo.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public List<Libro> buscarPorAutor(String autorBuscado) {
        // Filtrar los libros por autor
        return libros.stream()
                .filter(l -> l.getAutor().toLowerCase().equals(autorBuscado.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Libro> buscarPorGenero(String genero) {
        return libros.stream()
                .filter(l -> l.getGenero().toLowerCase().equals(genero.toLowerCase()))
                .collect(Collectors.toList());
    }

    public int totalLibros() {
        return libros.size();
    }

    public int totalUsarios() {
        return usuarios.size();
    }

    public int totalLibrosAlquilados () {
        int totalLibrosAlquilados = 0;
        for (Libro libro : libros) {
            if (libro.isAlquilado())
                totalLibrosAlquilados += 1;
        }
        return totalLibrosAlquilados;
    }
    public Map<String, Long> cantLibrosPorGenero() {
        return libros.stream()
                .collect(Collectors.groupingBy(Libro::getGenero, Collectors.counting()));
    }

    public Map<String, Long> cantLibrosPorAutor() {
        return libros.stream()
                .collect(Collectors.groupingBy(Libro::getAutor, Collectors.counting()));
    }

    public String autorMasAlquilado() {
        Map<String, Integer> cantDeAlquileresPorAutor = new HashMap<>();

        for (Libro libro : libros) {
            if (libro.isAlquilado()) {
                String autor = libro.getAutor();
                if (cantDeAlquileresPorAutor.containsKey(autor)) {
                    int cant = cantDeAlquileresPorAutor.get(autor);
                    cantDeAlquileresPorAutor.put(autor, cant + 1);
                } else {
                    cantDeAlquileresPorAutor.put(autor, 1);
                }
            }
        }

        String autorMasAlquilado = cantDeAlquileresPorAutor.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        return autorMasAlquilado;
    }

    // Getters y Setters
    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "libros=" + libros +
                ", usuarios=" + usuarios +
                '}';
    }

}
