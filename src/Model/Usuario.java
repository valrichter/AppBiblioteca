package Model;

import java.util.ArrayList;
import java.util.Map;

public class Usuario {
    private Integer dni;
    private String nombre;
    private String apellido;
    private ArrayList<Alquiler> alquileres;

    public Usuario(Integer dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.alquileres = new ArrayList<>();
    }

    public void alquilarLibro(Libro libro, Biblioteca biblioteca) throws Exception {
        Libro libroAlquilado = biblioteca.alquilarLibroAUsuario(libro, this.dni);
        if (libroAlquilado == null) {
            throw new Error("Libro no existe");
        }
        Alquiler nuevoAlquiler = new Alquiler(libro, this);
        alquileres.add(nuevoAlquiler);
        System.out.println(alquileres);
    }


    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
