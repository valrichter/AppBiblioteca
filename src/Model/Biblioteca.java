package Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Biblioteca {
    private Set<Libro> libros;
    private Set<Usuario> usuarios;
    private Map<Usuario, Libro[]> alquileres; // Map{ Usuario : LibrosAlquilados[] }

    public Biblioteca() {
        this.libros = new HashSet<>();
        this.usuarios = new HashSet<>();
        this.alquileres = new HashMap<>();
    }

    // Método para registrar un nuevo usuario
    public void registrarUsuario(Usuario usuario) {

        // Verificar si el usuario ya está registrado
        if (usuarios.contains(usuario)) {
            System.out.println("El usuario '" + usuario + "' ya está registrado.");
        } else {
            // Crear un nuevo usuario y agregarlo a la lista
            String nombreUsuario = usuario.getNombre();
            String apellidoUsuario = usuario.getApellido();
            Integer dniUsuario = usuario.getDni();

            Usuario nuevoUsuario = new Usuario(dniUsuario, nombreUsuario, apellidoUsuario);
            usuarios.add(nuevoUsuario);
            System.out.println("Usuario '" + nuevoUsuario + "' registrado exitosamente.");
        }
    }

    public void agregarLibro(String titulo, String autor, String genero) {
        Libro nuevoLibro = new Libro(titulo, autor, genero);
        libros.add(nuevoLibro);
        System.out.println("Libro '" + titulo + "' agregado a la biblioteca.");
    }

    public void eliminarLibro(String titulo) {
        // Usar un iterador para evitar ConcurrentModificationException
        libros.removeIf(libro -> libro.getTitulo().equals(titulo));
        System.out.println("Libro '" + titulo + "' eliminado de la biblioteca.");
    }

    // Getters y Setters
    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Map<Usuario, Libro[]> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(Map<Usuario, Libro[]> alquileres) {
        this.alquileres = alquileres;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "libros=" + libros +
                ", usuarios=" + usuarios +
                ", alquileres=" + alquileres +
                '}';
    }
}
