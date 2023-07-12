package entidades;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class Alquiler {

    /**
     * Dos metodos para crear fechas y diferencia de dias:
     * * * METODO 01 - DATE * * *
     * import java.util.Date;
     *    public class DaysBetweenDates {
     *      public static void main(String[] args) {
     *          Date start = new Date("2023-06-23");
     *          Date end = new Date("2023-07-01");
     *          long difference = end.getTime() - start.getTime();
     *          int days = (int) (difference / (1000 * 60 * 60 * 24));
     *          System.out.println("The difference in days between " + start + " and " + end + " is " + days);
     *      } 
     *  }
     * * * METODO 02 - PERIOD Y LOCALDATE * * *
     * import java.time.Period;
     * public class DaysBetweenDates {
     *    public static void main(String[] args) {
     *      LocalDate primera = LocalDate.of(2023, 6, 23);
     *      LocalDate segunda = LocalDate.of(2023, 7, 1);
     *      Period diferencia = Period.between(start, end);
     *      int dias = diferencia.getDays();
     *      System.out.println("La diferencia entre " + start + " y " + end + " es" + dias);
     *    }
     * }
     */
    private String nombre;
    private long documento;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private int posicionAmarre;
    private Barco barco;

    public Alquiler() {
    }

    public Alquiler(String nombre, long documento, LocalDate fechaAlquiler, LocalDate fechaDevolucion,
            int posicionAmarre, Barco barco) {
        this.nombre = nombre;
        this.documento = documento;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.posicionAmarre = posicionAmarre;
        this.barco = barco;
    }

    /**
     * Metodo para calcular los dias de ocupacion (fechaDevolucion -
     * fechaAlquiler) Si usamos DATE se calcula (FD.getTime() / 86400000) -
     * (FA.getTime() / 86400000)
     *
     * @return
     */
    public int calcularDiasOcupacion() {
        return (int) DAYS.between(fechaAlquiler, fechaDevolucion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getPosicionAmarre() {
        return posicionAmarre;
    }

    public void setPosicionAmarre(int posicionAmarre) {
        this.posicionAmarre = posicionAmarre;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    @Override
    public String toString() {
        return "Alquiler: Nombre: " + nombre + " Documento: " + documento + " Fecha Alquiler: "
                + fechaAlquiler.getDayOfMonth() + "-" + fechaAlquiler.getMonthValue() + "-"
                + fechaAlquiler.getYear() + " Fecha Devolucion: " + fechaDevolucion.getDayOfMonth() + "-"
                + fechaDevolucion.getMonthValue() + "-" + fechaDevolucion.getYear() + " Posicion Amarre: "
                + posicionAmarre + barco;
    }

}
