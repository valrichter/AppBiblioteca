import Model.Biblioteca;
import Model.Libro;
import Model.Usuario;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario1 = new Usuario(1, "Ricardo", "Fort");
        Libro libro1 = new Libro("1984","George Orwell", "Distopia");
        Libro libro2 = new Libro("El señor de los anillos", "J.R.R. Tolkien", "Fantasia");
        Libro libro3 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Realismo magico");
        Libro libro4 = new Libro("CCCC","CCCC", "CCCCC");
        Libro libro5 = new Libro("DDDD","DDDD", "DDDDD");

        // Registro de usuarios
        biblioteca.registrarUsuario(usuario1);
//        System.out.println(biblioteca.getUsuarios());

        // Agregar libro
        biblioteca.agregarLibro("1984","George Orwell", "Distopia");
//        System.out.println(biblioteca.getLibros());

        // Eliminar libro
        biblioteca.eliminarLibro("1984");
//        System.out.println(biblioteca.getLibros());


    }
}