package entidades;

public class FourStars extends Hotel {

    private char gimnasio;
    private String nomRestaurante;
    private int capacidadResto;

    public FourStars() {
        super();
        this.gimnasio = 'x';
        this.nomRestaurante = "";
        this.capacidadResto = 0;
    }

    public FourStars(char gimnasio, String nomRestaurante, int capacidadResto, int cantHabitaciones,
            int numCamas, int cantPisos, String nombre, String direccion,
            String localidad, String encargado) {
        super(cantHabitaciones, numCamas, cantPisos, nombre, direccion, localidad, encargado);
        this.gimnasio = gimnasio;
        this.nomRestaurante = nomRestaurante;
        this.capacidadResto = capacidadResto;
    }

    public char getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(char gimnasio) {
        this.gimnasio = gimnasio;
    }

    public String getNomRestaurante() {
        return nomRestaurante;
    }

    public void setNomRestaurante(String nomRestaurante) {
        this.nomRestaurante = nomRestaurante;
    }

    public int getCapacidadResto() {
        return capacidadResto;
    }

    public void setCapacidadResto(int capacidadResto) {
        this.capacidadResto = capacidadResto;
    }

    /**
     * Valor agregado por el gimnasio: $50 si el tipo del gimnasio es A. $30 si el tipo del gimnasio es B.
     *
     * @return
     */
    public int valorGimnasio() {
        Character.toUpperCase(gimnasio);
        return gimnasio == 'A' ? 50 : 30;
    }

    /**
     * Valor agregado por el restaurante: $10 si la capacidad del restaurante es de menos de 30 personas. 
     * $30 si está entre 30 y 50 personas y $50 si es mayor de 50.
     *
     * @return
     */
    public int valorResto() {
        if (capacidadResto <= 30) {
            return 10;
        } else {
            if (capacidadResto > 30 && capacidadResto <= 50) {
                return 30;
            } else {
                return 50;
            }
        }
    }

    /**
     * PrecioHabitación = $50 + ($1 x capacidad del hotel) + (valor agregado por restaurante) + 
     * (valor agregado por gimnasio) + (valor agregado por limosinas).
     *
     * @return
     */
    public Integer precioHabitacion() {
        return costoCapacidadHotel() + valorResto() + valorGimnasio();
    }

    @Override
    public String toString() {
        return super.toString() + "\nFourStars: " + " - Gimnasio: Tipo " + gimnasio + " - Nom. Restaurante: " + nomRestaurante
                + " - Cap. Resto: " + capacidadResto;
    }

}
