package Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Alquiler {
    String id;
    Libro libro;
    Usuario usuario;
    LocalDate fechaAlquiler;
    LocalDate fechaVencimiento;

    public Alquiler(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaAlquiler = LocalDate.now();
        this.fechaVencimiento = fechaAlquiler.plusDays(7);
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "id='" + id + '\'' +
                ", libro=" + libro +
                ", usuario=" + usuario +
                ", fechaAlquiler=" + fechaAlquiler +
                ", fechaVencimiento=" + fechaVencimiento +
                '}';
    }
}
