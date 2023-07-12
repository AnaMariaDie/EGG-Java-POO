package entidades;

public class FiveStars extends FourStars {

    private int cantSalonesConferencia;
    private int cantSuites;
    private int cantLimosinas;

    public FiveStars() {
        super();
        this.cantSalonesConferencia = 0;
        this.cantSuites = 0;
        this.cantLimosinas = 0;
    }

    public FiveStars(int cantSalonesConferencia, int cantSuites, int cantLimosinas, char gimnasio,
            String nomRestaurante, int capacidadResto, int cantHabitaciones, int numCamas, int cantPisos,
            String nombre, String direccion, String localidad, String encargado) {
        super(gimnasio, nomRestaurante, capacidadResto, cantHabitaciones, numCamas, cantPisos, nombre,
                direccion, localidad, encargado);
        this.cantSalonesConferencia = cantSalonesConferencia;
        this.cantSuites = cantSuites;
        this.cantLimosinas = cantLimosinas;
    }

    public int getCantSalonesConferencia() {
        return cantSalonesConferencia;
    }

    public void setCantSalonesConferencia(int cantSalonesConferencia) {
        this.cantSalonesConferencia = cantSalonesConferencia;
    }

    public int getCantSuites() {
        return cantSuites;
    }

    public void setCantSuites(int cantSuites) {
        this.cantSuites = cantSuites;
    }

    public int getCantLimosinas() {
        return cantLimosinas;
    }

    public void setCantLimosinas(int cantLimosinas) {
        this.cantLimosinas = cantLimosinas;
    }

    /**
     * Valor agregado por las limosinas: $15 por la cantidad de limosinas del hotel.
     *
     * @return
     */
    public int valorLimosinas() {
        return cantLimosinas * 15;
    }

    /**
     * PrecioHabitación = $50 + ($1 x capacidad del hotel) + (valor agregado por restaurante) + 
     * (valor agregado por gimnasio) + (valor agregado por limosinas).
     *
     * @return
     */
    @Override
    public Integer precioHabitacion() {
        return super.precioHabitacion() + valorLimosinas();
    }

    @Override
    public String toString() {
        return super.toString() + "\nFiveStars: Cant. Salones Conferencia: " + cantSalonesConferencia
                + " - Cant. Suites: " + cantSuites + " - Cant. Limosinas: " + cantLimosinas;
    }

}
