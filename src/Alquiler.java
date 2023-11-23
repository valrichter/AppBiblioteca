import java.util.Date;

// EL USUARIO SOLO PODRA ALQUILAR SOLO UNA COPIA DE UN LIBRO
public class Alquiler {
    Libro libro;
    Usuario usuario;
    Date fechaAlquiler;
    Date fechaVecimiento;

    public Alquiler(Libro libro, Usuario usuario, Date fechaAlquiler, Date fechaVecimiento) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaVecimiento = fechaVecimiento;
    }
}
