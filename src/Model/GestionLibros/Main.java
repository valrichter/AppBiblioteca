package Model.GestionLibros;

import Model.Biblioteca;
import Model.Libro;
import Model.Usuario;

public class Main {
    /*
        1. Gestión de Libros:
        - Los usuarios pueden agregar nuevos libros a la biblioteca.
        - Los usuarios pueden eliminar libros de la biblioteca.
    */
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario1 = new Usuario(1, "Ricardo", "Fort");

        Libro libro1 = new Libro("1984", "George Orwell", "Distopia");
        Libro libro2 = new Libro("El señor de los anillos", "J.R.R. Tolkien", "Fantasia");
        Libro libro3 = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "Realismo magico");
        Libro libro4 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "Fantasia");
        Libro libro5 = new Libro("Animal Farm", "George Orwell", "Alegoria politica");
        Libro libro6 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "Novela");

        // Registro de usuarios
        System.out.println("Registrar usuario:");
        biblioteca.registrarUsuario(usuario1);
        System.out.println();

        // Agregar libro
        System.out.println("Agregar libros:");
        usuario1.agregarLibro(libro1, biblioteca);
        usuario1.agregarLibro(libro4, biblioteca);
        usuario1.agregarLibro(libro5, biblioteca);
        usuario1.agregarLibro(libro6, biblioteca);
        usuario1.agregarLibro(libro2, biblioteca);
        usuario1.agregarLibro(libro3, biblioteca);
        System.out.println();

        // Eliminar libro
        System.out.println("Eliminar libros:");
        usuario1.eliminarLibro(libro6, biblioteca);
        System.out.println();

        // TODOS LOS LIBROS DE LA BIBLIOTECA
        System.out.println("TODOS LOS LIBROS:");
        biblioteca.getLibros().forEach(System.out::println);
    }
}
