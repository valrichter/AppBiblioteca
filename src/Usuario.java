public class Usuario {
    private Integer dni;
    private String nombre;
    private String apellido;

    public Usuario(Integer dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void devolverLibro() {

    }
    public void agregarLibro(Biblioteca b, Libro l) {
        b.agregarLibro(l);
    }
}
