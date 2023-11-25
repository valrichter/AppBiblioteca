package Model.GestionLibros;

import Model.Biblioteca;
import Model.Libro;
import Model.Usuario;

import java.util.Scanner;

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

        // Registro de usuarios
        System.out.println("Registrar usuario:");
        biblioteca.registrarUsuario(usuario1);
        // Agregamos unos libros de prueba
        usuario1.agregarLibro(libro1, biblioteca);
        System.out.println();

        // Agregar libro
        Scanner scanner = new Scanner(System.in);

        boolean agregarLibro = true;
        while (agregarLibro){
            System.out.println("Desea agregar un libro? SI o NO");
            String eleccion = scanner.nextLine();

            if (eleccion.toLowerCase().equals("si")) {
                System.out.println("Ingrese el titulo del libro:");
                String titulo = scanner.nextLine();

                System.out.println("Ingrese el autor del libro:");
                String autor = scanner.nextLine();

                System.out.println("Ingrese el genero del libro:");
                String genero = scanner.nextLine();

                // Agrega el nuevoLibro a la biblioteca
                Libro nuevoLibro = new Libro(titulo, autor, genero);
                usuario1.agregarLibro(nuevoLibro, biblioteca);
            }

            if (eleccion.toLowerCase().equals("no")) {
                System.out.println("TODOS LOS LIBROS DISPONIBLES:");
                biblioteca.getLibros().forEach(System.out::println);
                System.out.println();
                agregarLibro = false;
            }

            if (!eleccion.toLowerCase().equals("si") && !eleccion.toLowerCase().equals("no")) {
                System.out.println("INGRESE UNA OPCION VALIDA PORFAVOR");
            }
        }

        boolean eliminarLibro = true;
        while (eliminarLibro){
            System.out.println("Desea eliminar un libro? SI o NO");
            String eleccion = scanner.nextLine();

            if (eleccion.toLowerCase().equals("si")) {
                System.out.println("Ingrese el titulo del libro:");
                String titulo = scanner.nextLine();

                System.out.println("Ingrese el autor del libro:");
                String autor = scanner.nextLine();

                System.out.println("Ingrese el genero del libro:");
                String genero = scanner.nextLine();

                // Agrega el nuevoLibro a la biblioteca
                Libro nuevoLibro = new Libro(titulo, autor, genero);
                usuario1.eliminarLibro(nuevoLibro, biblioteca);
            }

            if (eleccion.toLowerCase().equals("no")) {
                System.out.println("TODOS LOS LIBROS DISPONIBLES:");
                biblioteca.getLibros().forEach(System.out::println);
                System.out.println();
                eliminarLibro = false;
            }

            if (!eleccion.toLowerCase().equals("si") && !eleccion.toLowerCase().equals("no")) {
                System.out.println("INGRESE UNA OPCION VALIDA PORFAVOR");
            }
        }

        // TODOS LOS LIBROS DE LA BIBLIOTECA
        System.out.println("TODOS LOS LIBROS QUE QUEDARON DESPUES DE AGREGAR Y ELIMNAR:");
        biblioteca.getLibros().forEach(System.out::println);
    }
}
