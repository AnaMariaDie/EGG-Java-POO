package entidades;

public class Hotel extends Alojamiento {

    private int cantHabitaciones;
    private int numCamas;
    private int cantPisos;
    private Integer precioHabitacion = 50;

    public Hotel() {
        super();
        this.cantHabitaciones = 0;
        this.numCamas = 0;
        this.cantPisos = 0;
    }

    public Hotel(int cantHabitaciones, int numCamas, int cantPisos, String nombre, String direccion,
            String localidad, String encargado) {
        super(nombre, direccion, localidad, encargado);
        this.cantHabitaciones = cantHabitaciones;
        this.numCamas = numCamas;
        this.cantPisos = cantPisos;
    }

    public int getCantHabitaciones() {
        return cantHabitaciones;
    }

    public void setCantHabitaciones(int cantHabitaciones) {
        this.cantHabitaciones = cantHabitaciones;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }

    public int getCantPisos() {
        return cantPisos;
    }

    public void setCantPisos(int cantPisos) {
        this.cantPisos = cantPisos;
    }

    public Integer getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(Integer precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    /**
     * Metodo que calcula la Capacidad del Hotel de acuerdo a las habitaciones, camas y pisos + el precio
     * de la habitacion
     * @return
     */
    public int costoCapacidadHotel() {
        return (cantHabitaciones * numCamas * cantPisos) + precioHabitacion;
    }

    @Override
    public String toString() {
        return "\nHotel: Cant. Habitaciones: " + cantHabitaciones + " - Num. Camas: " + numCamas
                + " - Cant. Pisos: " + cantPisos + " - Precio Habitacion: " + precioHabitacion;
    }

}
