import Model.Biblioteca;
import Model.Libro;
import Model.Usuario;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario1 = new Usuario(1, "Ricardo", "Fort");

        Libro libro1 = new Libro("1984", "George Orwell", "Distopia");
        Libro libro2 = new Libro("El señor de los anillos", "J.R.R. Tolkien", "Fantasia");
        Libro libro3 = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "Realismo magico");
        Libro libro4 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "Fantasia");
        Libro libro5 = new Libro("Animal Farm", "George Orwell", "Alegoria politica");
        Libro libro6 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "Novela");
        Libro libro7 = new Libro("Los juegos del hambre", "Suzanne Collins", "Ciencia ficción");
        Libro libro8 = new Libro("Crónica de una muerte anunciada", "Gabriel Garcia Marquez", "Realismo magico");
        Libro libro9 = new Libro("El Código Da Vinci", "Dan Brown", "Misterio");
        Libro libro10 = new Libro("La Odisea", "Homero", "Epopeya");

        // Registro de usuarios
        System.out.println("Registrar usuario:");
        biblioteca.registrarUsuario(usuario1);
        System.out.println();
//        System.out.println(biblioteca.getUsuarios());

        // Agregar libro
        System.out.println("Agregar libros:");
        usuario1.agregarLibro(libro1, biblioteca);
        usuario1.agregarLibro(libro2, biblioteca);
        usuario1.agregarLibro(libro3, biblioteca);
        usuario1.agregarLibro(libro4, biblioteca);
        usuario1.agregarLibro(libro5, biblioteca);
        usuario1.agregarLibro(libro6, biblioteca);
        System.out.println();
//        System.out.println(biblioteca.getLibros());

        // Eliminar libro
        System.out.println("Eliminar libros:");
        usuario1.eliminarLibro(libro6, biblioteca);
//        System.out.println(biblioteca.getLibros());
        System.out.println();

        // Alquilar libro
        System.out.println("Alquilar libros:");
        usuario1.alquilarLibro(libro1, biblioteca);
        usuario1.alquilarLibro(libro2, biblioteca);
        usuario1.alquilarLibro(libro5, biblioteca);
        System.out.println();

        // Alquilar libro alquilado
//        usuario1.alquilarLibro(libro1, biblioteca);

        // Devolver libro
        System.out.println("Devolver libros:");
        LocalDate fechaDevolcion = LocalDate.of(2023, 6, 12);
        usuario1.devolverLibro(libro2, biblioteca, fechaDevolcion);
        System.out.println();

        // Buscar por título
        System.out.println("Buscar por titulo:");
        usuario1.buscarPorTitulo("el señor de los anillos", biblioteca);
        System.out.println();

        // Buscar por autor
        System.out.println("Buscar por autor:");
        List<Libro> librosDelAutor = usuario1.buscarPorAutor("george orwell", biblioteca);
        librosDelAutor.forEach(System.out::println);
        System.out.println();

        // Buscar por genero
        System.out.println("Buscar por genero:");
        List<Libro> librosPorGenero = usuario1.buscarPorGenero("fantasia", biblioteca);
        librosPorGenero.forEach(System.out::println);
        System.out.println();

        // Generar informe
        System.out.println("Informe:");
        usuario1.generarInformeDeBiblioteca(biblioteca);
        System.out.println();
    }
}