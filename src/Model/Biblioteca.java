package Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
            System.out.println("El usuario '" + usuario + "' ya está registrado.");
        } else {
            // Crear un nuevo usuario y agregarlo a la lista
            String nombreUsuario = usuario.getNombre();
            String apellidoUsuario = usuario.getApellido();
            Integer dniUsuario = usuario.getDni();

            Usuario nuevoUsuario = new Usuario(dniUsuario, nombreUsuario, apellidoUsuario);
            usuarios.put(dniUsuario, nuevoUsuario);
            System.out.println("Usuario '" + nuevoUsuario + "' registrado exitosamente.");
        }
    }

    public void agregarLibro(Libro nuevoLibro) {
        libros.add(nuevoLibro);
        System.out.println("Libro '" + nuevoLibro + "' agregado a la biblioteca.");
    }

    public void eliminarLibro(String titulo) {
        // Usar un iterador para evitar ConcurrentModificationException
        libros.removeIf(libro -> libro.getTitulo().equals(titulo));
        System.out.println("Libro '" + titulo + "' eliminado de la biblioteca.");
    }

    public Libro alquilarLibroAUsuario(Libro libro, Integer dniUsuario) throws Exception {
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
