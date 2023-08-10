package entidades;

public class Residencias extends ExtraHotelero {

    private int cantHabitaciones;
    private boolean descGremio;
    private boolean campoDepo;

    public Residencias() {
        super();
        this.cantHabitaciones = 0;
        this.descGremio = false;
        this.campoDepo = false;
    }

    public Residencias(int cantHabitaciones, boolean descGremio, boolean campoDepo, boolean privado, 
            int cantMts2, String nombre, String direccion, String localidad, String encargado) {
        super(privado, cantMts2, nombre, direccion, localidad, encargado);
        this.cantHabitaciones = cantHabitaciones;
        this.descGremio = descGremio;
        this.campoDepo = campoDepo;
    }

    public int getCantHabitaciones() {
        return cantHabitaciones;
    }

    public void setCantHabitaciones(int cantHabitaciones) {
        this.cantHabitaciones = cantHabitaciones;
    }

    public boolean isDescGremio() {
        return descGremio;
    }

    public void setDescGremio(boolean descGremio) {
        this.descGremio = descGremio;
    }

    public boolean isCampoDepo() {
        return campoDepo;
    }

    public void setCampoDepo(boolean campoDepo) {
        this.campoDepo = campoDepo;
    }

    /**
     * Le vamos a sumar a la Entrada el valor de la capacidad de habitaciones, si tiene campo
     * y haremos descuento si tiene por gremio.
     * @return 
     */
    @Override
    public int valorEntrada() {
        int campo = campoDepo ? 500 : 0;
        int desc = descGremio ? 10 : 0;
        int preciofinal = (super.valorEntrada() * cantHabitaciones) + campo;
        if (desc != 0) {
            return (preciofinal - (desc * preciofinal / 100));  
        }
        return preciofinal;
    }
    
    @Override
    public String toString() {
        String desc = descGremio ? "Tiene descuento -" : "No tiene descuento -";
        String aux = campoDepo ? " Tiene Campo Deportivo" : " No tiene Campo Deportivo";
        return super.toString() + "\nResidencias: Cant. Habitaciones: " + cantHabitaciones + 
                " - Desc. Por Gremio: " + desc + aux;
    }
}
